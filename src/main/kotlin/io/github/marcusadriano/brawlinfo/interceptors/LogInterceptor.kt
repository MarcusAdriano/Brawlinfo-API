package io.github.marcusadriano.brawlinfo.interceptors

import io.github.marcusadriano.brawlinfo.Config
import io.grpc.*
import mu.KLogger
import mu.KotlinLogging

class LogInterceptor: ServerInterceptor {

    private val logger = KotlinLogging.logger {}

    override fun <ReqT : Any?, RespT : Any?> interceptCall(
            call: ServerCall<ReqT, RespT>?,
            headers: Metadata?,
            next: ServerCallHandler<ReqT, RespT>?): ServerCall.Listener<ReqT> {

        call?.let {
            logger.info { "--> Entry Method= ${it.methodDescriptor.fullMethodName}, type= ${it.methodDescriptor.type}" }
        }

        return next!!.startCall(SimpleFwdCall(call), headers)
    }
}

private class SimpleFwdCall<ReqT : Any?, RespT : Any?>(delegate: ServerCall<ReqT, RespT>?) :
        ForwardingServerCall.SimpleForwardingServerCall<ReqT, RespT>(delegate) {

    private val logger: KLogger = KotlinLogging.logger {}
    private val config = Config.getInstance()

    override fun sendMessage(message: RespT) {
        super.sendMessage(message)
        val logMessage = processLogMessage(message.toString())
        logger.info { "<-- Exit Response: $logMessage" }
    }

    private fun processLogMessage(logMessage: String): String {
        val maxMessageSize: Int = config.get("log.max-size", "100").toInt()
        var message = logMessage
        message = message.replace("\n", "")
        if (message.length > maxMessageSize) {
            message = "${message.substring(0, maxMessageSize)}..."
        }
        return message
    }

}