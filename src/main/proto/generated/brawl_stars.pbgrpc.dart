///
//  Generated code. Do not modify.
//  source: brawl_stars.proto
//
// @dart = 2.3
// ignore_for_file: camel_case_types,non_constant_identifier_names,library_prefixes,unused_import,unused_shown_name,return_of_invalid_type

import 'dart:async' as $async;

import 'dart:core' as $core;

import 'package:grpc/service_api.dart' as $grpc;
import 'brawl_stars.pb.dart' as $0;
export 'brawl_stars.pb.dart';

class BrawlStarsClient extends $grpc.Client {
  static final _$getPlayer = $grpc.ClientMethod<$0.BSPlayerRequest, $0.Player>(
      '/BrawlStars/GetPlayer',
      ($0.BSPlayerRequest value) => value.writeToBuffer(),
      ($core.List<$core.int> value) => $0.Player.fromBuffer(value));

  BrawlStarsClient($grpc.ClientChannel channel, {$grpc.CallOptions options})
      : super(channel, options: options);

  $grpc.ResponseFuture<$0.Player> getPlayer($0.BSPlayerRequest request,
      {$grpc.CallOptions options}) {
    final call = $createCall(_$getPlayer, $async.Stream.fromIterable([request]),
        options: options);
    return $grpc.ResponseFuture(call);
  }
}

abstract class BrawlStarsServiceBase extends $grpc.Service {
  $core.String get $name => 'BrawlStars';

  BrawlStarsServiceBase() {
    $addMethod($grpc.ServiceMethod<$0.BSPlayerRequest, $0.Player>(
        'GetPlayer',
        getPlayer_Pre,
        false,
        false,
        ($core.List<$core.int> value) => $0.BSPlayerRequest.fromBuffer(value),
        ($0.Player value) => value.writeToBuffer()));
  }

  $async.Future<$0.Player> getPlayer_Pre(
      $grpc.ServiceCall call, $async.Future<$0.BSPlayerRequest> request) async {
    return getPlayer(call, await request);
  }

  $async.Future<$0.Player> getPlayer(
      $grpc.ServiceCall call, $0.BSPlayerRequest request);
}
