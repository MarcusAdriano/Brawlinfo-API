///
//  Generated code. Do not modify.
//  source: brawl_stars.proto
//
// @dart = 2.3
// ignore_for_file: camel_case_types,non_constant_identifier_names,library_prefixes,unused_import,unused_shown_name,return_of_invalid_type

import 'dart:core' as $core;

import 'package:protobuf/protobuf.dart' as $pb;

class BSPlayerRequest extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo('BSPlayerRequest', createEmptyInstance: create)
    ..aOS(1, 'gameTag', protoName: 'gameTag')
    ..hasRequiredFields = false
  ;

  BSPlayerRequest._() : super();
  factory BSPlayerRequest() => create();
  factory BSPlayerRequest.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory BSPlayerRequest.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  BSPlayerRequest clone() => BSPlayerRequest()..mergeFromMessage(this);
  BSPlayerRequest copyWith(void Function(BSPlayerRequest) updates) => super.copyWith((message) => updates(message as BSPlayerRequest));
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static BSPlayerRequest create() => BSPlayerRequest._();
  BSPlayerRequest createEmptyInstance() => create();
  static $pb.PbList<BSPlayerRequest> createRepeated() => $pb.PbList<BSPlayerRequest>();
  @$core.pragma('dart2js:noInline')
  static BSPlayerRequest getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<BSPlayerRequest>(create);
  static BSPlayerRequest _defaultInstance;

  @$pb.TagNumber(1)
  $core.String get gameTag => $_getSZ(0);
  @$pb.TagNumber(1)
  set gameTag($core.String v) { $_setString(0, v); }
  @$pb.TagNumber(1)
  $core.bool hasGameTag() => $_has(0);
  @$pb.TagNumber(1)
  void clearGameTag() => clearField(1);
}

class Player_CLUB extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo('Player.CLUB', createEmptyInstance: create)
    ..aOS(1, 'tag')
    ..aOS(2, 'name')
    ..hasRequiredFields = false
  ;

  Player_CLUB._() : super();
  factory Player_CLUB() => create();
  factory Player_CLUB.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory Player_CLUB.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  Player_CLUB clone() => Player_CLUB()..mergeFromMessage(this);
  Player_CLUB copyWith(void Function(Player_CLUB) updates) => super.copyWith((message) => updates(message as Player_CLUB));
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static Player_CLUB create() => Player_CLUB._();
  Player_CLUB createEmptyInstance() => create();
  static $pb.PbList<Player_CLUB> createRepeated() => $pb.PbList<Player_CLUB>();
  @$core.pragma('dart2js:noInline')
  static Player_CLUB getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<Player_CLUB>(create);
  static Player_CLUB _defaultInstance;

  @$pb.TagNumber(1)
  $core.String get tag => $_getSZ(0);
  @$pb.TagNumber(1)
  set tag($core.String v) { $_setString(0, v); }
  @$pb.TagNumber(1)
  $core.bool hasTag() => $_has(0);
  @$pb.TagNumber(1)
  void clearTag() => clearField(1);

  @$pb.TagNumber(2)
  $core.String get name => $_getSZ(1);
  @$pb.TagNumber(2)
  set name($core.String v) { $_setString(1, v); }
  @$pb.TagNumber(2)
  $core.bool hasName() => $_has(1);
  @$pb.TagNumber(2)
  void clearName() => clearField(2);
}

class Player_BRAWLERS_STARPOWERS_NAME extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo('Player.BRAWLERS.STARPOWERS.NAME', createEmptyInstance: create)
    ..hasRequiredFields = false
  ;

  Player_BRAWLERS_STARPOWERS_NAME._() : super();
  factory Player_BRAWLERS_STARPOWERS_NAME() => create();
  factory Player_BRAWLERS_STARPOWERS_NAME.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory Player_BRAWLERS_STARPOWERS_NAME.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  Player_BRAWLERS_STARPOWERS_NAME clone() => Player_BRAWLERS_STARPOWERS_NAME()..mergeFromMessage(this);
  Player_BRAWLERS_STARPOWERS_NAME copyWith(void Function(Player_BRAWLERS_STARPOWERS_NAME) updates) => super.copyWith((message) => updates(message as Player_BRAWLERS_STARPOWERS_NAME));
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_STARPOWERS_NAME create() => Player_BRAWLERS_STARPOWERS_NAME._();
  Player_BRAWLERS_STARPOWERS_NAME createEmptyInstance() => create();
  static $pb.PbList<Player_BRAWLERS_STARPOWERS_NAME> createRepeated() => $pb.PbList<Player_BRAWLERS_STARPOWERS_NAME>();
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_STARPOWERS_NAME getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<Player_BRAWLERS_STARPOWERS_NAME>(create);
  static Player_BRAWLERS_STARPOWERS_NAME _defaultInstance;
}

class Player_BRAWLERS_STARPOWERS extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo('Player.BRAWLERS.STARPOWERS', createEmptyInstance: create)
    ..aOM<Player_BRAWLERS_STARPOWERS_NAME>(1, 'name', subBuilder: Player_BRAWLERS_STARPOWERS_NAME.create)
    ..a<$core.double>(2, 'id', $pb.PbFieldType.OD)
    ..hasRequiredFields = false
  ;

  Player_BRAWLERS_STARPOWERS._() : super();
  factory Player_BRAWLERS_STARPOWERS() => create();
  factory Player_BRAWLERS_STARPOWERS.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory Player_BRAWLERS_STARPOWERS.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  Player_BRAWLERS_STARPOWERS clone() => Player_BRAWLERS_STARPOWERS()..mergeFromMessage(this);
  Player_BRAWLERS_STARPOWERS copyWith(void Function(Player_BRAWLERS_STARPOWERS) updates) => super.copyWith((message) => updates(message as Player_BRAWLERS_STARPOWERS));
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_STARPOWERS create() => Player_BRAWLERS_STARPOWERS._();
  Player_BRAWLERS_STARPOWERS createEmptyInstance() => create();
  static $pb.PbList<Player_BRAWLERS_STARPOWERS> createRepeated() => $pb.PbList<Player_BRAWLERS_STARPOWERS>();
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_STARPOWERS getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<Player_BRAWLERS_STARPOWERS>(create);
  static Player_BRAWLERS_STARPOWERS _defaultInstance;

  @$pb.TagNumber(1)
  Player_BRAWLERS_STARPOWERS_NAME get name => $_getN(0);
  @$pb.TagNumber(1)
  set name(Player_BRAWLERS_STARPOWERS_NAME v) { setField(1, v); }
  @$pb.TagNumber(1)
  $core.bool hasName() => $_has(0);
  @$pb.TagNumber(1)
  void clearName() => clearField(1);
  @$pb.TagNumber(1)
  Player_BRAWLERS_STARPOWERS_NAME ensureName() => $_ensure(0);

  @$pb.TagNumber(2)
  $core.double get id => $_getN(1);
  @$pb.TagNumber(2)
  set id($core.double v) { $_setDouble(1, v); }
  @$pb.TagNumber(2)
  $core.bool hasId() => $_has(1);
  @$pb.TagNumber(2)
  void clearId() => clearField(2);
}

class Player_BRAWLERS_GADGETS_NAME extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo('Player.BRAWLERS.GADGETS.NAME', createEmptyInstance: create)
    ..hasRequiredFields = false
  ;

  Player_BRAWLERS_GADGETS_NAME._() : super();
  factory Player_BRAWLERS_GADGETS_NAME() => create();
  factory Player_BRAWLERS_GADGETS_NAME.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory Player_BRAWLERS_GADGETS_NAME.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  Player_BRAWLERS_GADGETS_NAME clone() => Player_BRAWLERS_GADGETS_NAME()..mergeFromMessage(this);
  Player_BRAWLERS_GADGETS_NAME copyWith(void Function(Player_BRAWLERS_GADGETS_NAME) updates) => super.copyWith((message) => updates(message as Player_BRAWLERS_GADGETS_NAME));
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_GADGETS_NAME create() => Player_BRAWLERS_GADGETS_NAME._();
  Player_BRAWLERS_GADGETS_NAME createEmptyInstance() => create();
  static $pb.PbList<Player_BRAWLERS_GADGETS_NAME> createRepeated() => $pb.PbList<Player_BRAWLERS_GADGETS_NAME>();
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_GADGETS_NAME getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<Player_BRAWLERS_GADGETS_NAME>(create);
  static Player_BRAWLERS_GADGETS_NAME _defaultInstance;
}

class Player_BRAWLERS_GADGETS extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo('Player.BRAWLERS.GADGETS', createEmptyInstance: create)
    ..aOM<Player_BRAWLERS_GADGETS_NAME>(1, 'name', subBuilder: Player_BRAWLERS_GADGETS_NAME.create)
    ..a<$core.double>(2, 'id', $pb.PbFieldType.OD)
    ..hasRequiredFields = false
  ;

  Player_BRAWLERS_GADGETS._() : super();
  factory Player_BRAWLERS_GADGETS() => create();
  factory Player_BRAWLERS_GADGETS.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory Player_BRAWLERS_GADGETS.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  Player_BRAWLERS_GADGETS clone() => Player_BRAWLERS_GADGETS()..mergeFromMessage(this);
  Player_BRAWLERS_GADGETS copyWith(void Function(Player_BRAWLERS_GADGETS) updates) => super.copyWith((message) => updates(message as Player_BRAWLERS_GADGETS));
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_GADGETS create() => Player_BRAWLERS_GADGETS._();
  Player_BRAWLERS_GADGETS createEmptyInstance() => create();
  static $pb.PbList<Player_BRAWLERS_GADGETS> createRepeated() => $pb.PbList<Player_BRAWLERS_GADGETS>();
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_GADGETS getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<Player_BRAWLERS_GADGETS>(create);
  static Player_BRAWLERS_GADGETS _defaultInstance;

  @$pb.TagNumber(1)
  Player_BRAWLERS_GADGETS_NAME get name => $_getN(0);
  @$pb.TagNumber(1)
  set name(Player_BRAWLERS_GADGETS_NAME v) { setField(1, v); }
  @$pb.TagNumber(1)
  $core.bool hasName() => $_has(0);
  @$pb.TagNumber(1)
  void clearName() => clearField(1);
  @$pb.TagNumber(1)
  Player_BRAWLERS_GADGETS_NAME ensureName() => $_ensure(0);

  @$pb.TagNumber(2)
  $core.double get id => $_getN(1);
  @$pb.TagNumber(2)
  set id($core.double v) { $_setDouble(1, v); }
  @$pb.TagNumber(2)
  $core.bool hasId() => $_has(1);
  @$pb.TagNumber(2)
  void clearId() => clearField(2);
}

class Player_BRAWLERS_NAME extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo('Player.BRAWLERS.NAME', createEmptyInstance: create)
    ..hasRequiredFields = false
  ;

  Player_BRAWLERS_NAME._() : super();
  factory Player_BRAWLERS_NAME() => create();
  factory Player_BRAWLERS_NAME.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory Player_BRAWLERS_NAME.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  Player_BRAWLERS_NAME clone() => Player_BRAWLERS_NAME()..mergeFromMessage(this);
  Player_BRAWLERS_NAME copyWith(void Function(Player_BRAWLERS_NAME) updates) => super.copyWith((message) => updates(message as Player_BRAWLERS_NAME));
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_NAME create() => Player_BRAWLERS_NAME._();
  Player_BRAWLERS_NAME createEmptyInstance() => create();
  static $pb.PbList<Player_BRAWLERS_NAME> createRepeated() => $pb.PbList<Player_BRAWLERS_NAME>();
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS_NAME getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<Player_BRAWLERS_NAME>(create);
  static Player_BRAWLERS_NAME _defaultInstance;
}

class Player_BRAWLERS extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo('Player.BRAWLERS', createEmptyInstance: create)
    ..pc<Player_BRAWLERS_STARPOWERS>(1, 'starPowers', $pb.PbFieldType.PM, protoName: 'starPowers', subBuilder: Player_BRAWLERS_STARPOWERS.create)
    ..pc<Player_BRAWLERS_GADGETS>(2, 'gadgets', $pb.PbFieldType.PM, subBuilder: Player_BRAWLERS_GADGETS.create)
    ..a<$core.double>(3, 'id', $pb.PbFieldType.OD)
    ..a<$core.double>(4, 'rank', $pb.PbFieldType.OD)
    ..a<$core.double>(5, 'trophies', $pb.PbFieldType.OD)
    ..a<$core.double>(6, 'highestTrophies', $pb.PbFieldType.OD, protoName: 'highestTrophies')
    ..a<$core.double>(7, 'power', $pb.PbFieldType.OD)
    ..aOM<Player_BRAWLERS_NAME>(8, 'name', subBuilder: Player_BRAWLERS_NAME.create)
    ..hasRequiredFields = false
  ;

  Player_BRAWLERS._() : super();
  factory Player_BRAWLERS() => create();
  factory Player_BRAWLERS.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory Player_BRAWLERS.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  Player_BRAWLERS clone() => Player_BRAWLERS()..mergeFromMessage(this);
  Player_BRAWLERS copyWith(void Function(Player_BRAWLERS) updates) => super.copyWith((message) => updates(message as Player_BRAWLERS));
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS create() => Player_BRAWLERS._();
  Player_BRAWLERS createEmptyInstance() => create();
  static $pb.PbList<Player_BRAWLERS> createRepeated() => $pb.PbList<Player_BRAWLERS>();
  @$core.pragma('dart2js:noInline')
  static Player_BRAWLERS getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<Player_BRAWLERS>(create);
  static Player_BRAWLERS _defaultInstance;

  @$pb.TagNumber(1)
  $core.List<Player_BRAWLERS_STARPOWERS> get starPowers => $_getList(0);

  @$pb.TagNumber(2)
  $core.List<Player_BRAWLERS_GADGETS> get gadgets => $_getList(1);

  @$pb.TagNumber(3)
  $core.double get id => $_getN(2);
  @$pb.TagNumber(3)
  set id($core.double v) { $_setDouble(2, v); }
  @$pb.TagNumber(3)
  $core.bool hasId() => $_has(2);
  @$pb.TagNumber(3)
  void clearId() => clearField(3);

  @$pb.TagNumber(4)
  $core.double get rank => $_getN(3);
  @$pb.TagNumber(4)
  set rank($core.double v) { $_setDouble(3, v); }
  @$pb.TagNumber(4)
  $core.bool hasRank() => $_has(3);
  @$pb.TagNumber(4)
  void clearRank() => clearField(4);

  @$pb.TagNumber(5)
  $core.double get trophies => $_getN(4);
  @$pb.TagNumber(5)
  set trophies($core.double v) { $_setDouble(4, v); }
  @$pb.TagNumber(5)
  $core.bool hasTrophies() => $_has(4);
  @$pb.TagNumber(5)
  void clearTrophies() => clearField(5);

  @$pb.TagNumber(6)
  $core.double get highestTrophies => $_getN(5);
  @$pb.TagNumber(6)
  set highestTrophies($core.double v) { $_setDouble(5, v); }
  @$pb.TagNumber(6)
  $core.bool hasHighestTrophies() => $_has(5);
  @$pb.TagNumber(6)
  void clearHighestTrophies() => clearField(6);

  @$pb.TagNumber(7)
  $core.double get power => $_getN(6);
  @$pb.TagNumber(7)
  set power($core.double v) { $_setDouble(6, v); }
  @$pb.TagNumber(7)
  $core.bool hasPower() => $_has(6);
  @$pb.TagNumber(7)
  void clearPower() => clearField(7);

  @$pb.TagNumber(8)
  Player_BRAWLERS_NAME get name => $_getN(7);
  @$pb.TagNumber(8)
  set name(Player_BRAWLERS_NAME v) { setField(8, v); }
  @$pb.TagNumber(8)
  $core.bool hasName() => $_has(7);
  @$pb.TagNumber(8)
  void clearName() => clearField(8);
  @$pb.TagNumber(8)
  Player_BRAWLERS_NAME ensureName() => $_ensure(7);
}

class Player extends $pb.GeneratedMessage {
  static final $pb.BuilderInfo _i = $pb.BuilderInfo('Player', createEmptyInstance: create)
    ..aOM<Player_CLUB>(1, 'club', subBuilder: Player_CLUB.create)
    ..aOB(3, 'isQualifiedFromChampionshipChallenge', protoName: 'isQualifiedFromChampionshipChallenge')
    ..aOS(4, 'tag')
    ..aOS(5, 'name')
    ..a<$core.double>(6, 'trophies', $pb.PbFieldType.OD)
    ..a<$core.double>(7, 'expLevel', $pb.PbFieldType.OD, protoName: 'expLevel')
    ..a<$core.double>(8, 'expPoints', $pb.PbFieldType.OD, protoName: 'expPoints')
    ..a<$core.double>(9, 'highestTrophies', $pb.PbFieldType.OD, protoName: 'highestTrophies')
    ..a<$core.double>(10, 'powerPlayPoints', $pb.PbFieldType.OD, protoName: 'powerPlayPoints')
    ..a<$core.double>(11, 'highestPowerPlayPoints', $pb.PbFieldType.OD, protoName: 'highestPowerPlayPoints')
    ..a<$core.double>(12, 'soloVictories', $pb.PbFieldType.OD, protoName: 'soloVictories')
    ..a<$core.double>(13, 'duoVictories', $pb.PbFieldType.OD, protoName: 'duoVictories')
    ..a<$core.double>(14, 'bestRoboRumbleTime', $pb.PbFieldType.OD, protoName: 'bestRoboRumbleTime')
    ..a<$core.double>(15, 'bestTimeAsBigBrawler', $pb.PbFieldType.OD, protoName: 'bestTimeAsBigBrawler')
    ..pc<Player_BRAWLERS>(16, 'brawlers', $pb.PbFieldType.PM, subBuilder: Player_BRAWLERS.create)
    ..aOS(17, 'nameColor', protoName: 'nameColor')
    ..hasRequiredFields = false
  ;

  Player._() : super();
  factory Player() => create();
  factory Player.fromBuffer($core.List<$core.int> i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromBuffer(i, r);
  factory Player.fromJson($core.String i, [$pb.ExtensionRegistry r = $pb.ExtensionRegistry.EMPTY]) => create()..mergeFromJson(i, r);
  Player clone() => Player()..mergeFromMessage(this);
  Player copyWith(void Function(Player) updates) => super.copyWith((message) => updates(message as Player));
  $pb.BuilderInfo get info_ => _i;
  @$core.pragma('dart2js:noInline')
  static Player create() => Player._();
  Player createEmptyInstance() => create();
  static $pb.PbList<Player> createRepeated() => $pb.PbList<Player>();
  @$core.pragma('dart2js:noInline')
  static Player getDefault() => _defaultInstance ??= $pb.GeneratedMessage.$_defaultFor<Player>(create);
  static Player _defaultInstance;

  @$pb.TagNumber(1)
  Player_CLUB get club => $_getN(0);
  @$pb.TagNumber(1)
  set club(Player_CLUB v) { setField(1, v); }
  @$pb.TagNumber(1)
  $core.bool hasClub() => $_has(0);
  @$pb.TagNumber(1)
  void clearClub() => clearField(1);
  @$pb.TagNumber(1)
  Player_CLUB ensureClub() => $_ensure(0);

  @$pb.TagNumber(3)
  $core.bool get isQualifiedFromChampionshipChallenge => $_getBF(1);
  @$pb.TagNumber(3)
  set isQualifiedFromChampionshipChallenge($core.bool v) { $_setBool(1, v); }
  @$pb.TagNumber(3)
  $core.bool hasIsQualifiedFromChampionshipChallenge() => $_has(1);
  @$pb.TagNumber(3)
  void clearIsQualifiedFromChampionshipChallenge() => clearField(3);

  @$pb.TagNumber(4)
  $core.String get tag => $_getSZ(2);
  @$pb.TagNumber(4)
  set tag($core.String v) { $_setString(2, v); }
  @$pb.TagNumber(4)
  $core.bool hasTag() => $_has(2);
  @$pb.TagNumber(4)
  void clearTag() => clearField(4);

  @$pb.TagNumber(5)
  $core.String get name => $_getSZ(3);
  @$pb.TagNumber(5)
  set name($core.String v) { $_setString(3, v); }
  @$pb.TagNumber(5)
  $core.bool hasName() => $_has(3);
  @$pb.TagNumber(5)
  void clearName() => clearField(5);

  @$pb.TagNumber(6)
  $core.double get trophies => $_getN(4);
  @$pb.TagNumber(6)
  set trophies($core.double v) { $_setDouble(4, v); }
  @$pb.TagNumber(6)
  $core.bool hasTrophies() => $_has(4);
  @$pb.TagNumber(6)
  void clearTrophies() => clearField(6);

  @$pb.TagNumber(7)
  $core.double get expLevel => $_getN(5);
  @$pb.TagNumber(7)
  set expLevel($core.double v) { $_setDouble(5, v); }
  @$pb.TagNumber(7)
  $core.bool hasExpLevel() => $_has(5);
  @$pb.TagNumber(7)
  void clearExpLevel() => clearField(7);

  @$pb.TagNumber(8)
  $core.double get expPoints => $_getN(6);
  @$pb.TagNumber(8)
  set expPoints($core.double v) { $_setDouble(6, v); }
  @$pb.TagNumber(8)
  $core.bool hasExpPoints() => $_has(6);
  @$pb.TagNumber(8)
  void clearExpPoints() => clearField(8);

  @$pb.TagNumber(9)
  $core.double get highestTrophies => $_getN(7);
  @$pb.TagNumber(9)
  set highestTrophies($core.double v) { $_setDouble(7, v); }
  @$pb.TagNumber(9)
  $core.bool hasHighestTrophies() => $_has(7);
  @$pb.TagNumber(9)
  void clearHighestTrophies() => clearField(9);

  @$pb.TagNumber(10)
  $core.double get powerPlayPoints => $_getN(8);
  @$pb.TagNumber(10)
  set powerPlayPoints($core.double v) { $_setDouble(8, v); }
  @$pb.TagNumber(10)
  $core.bool hasPowerPlayPoints() => $_has(8);
  @$pb.TagNumber(10)
  void clearPowerPlayPoints() => clearField(10);

  @$pb.TagNumber(11)
  $core.double get highestPowerPlayPoints => $_getN(9);
  @$pb.TagNumber(11)
  set highestPowerPlayPoints($core.double v) { $_setDouble(9, v); }
  @$pb.TagNumber(11)
  $core.bool hasHighestPowerPlayPoints() => $_has(9);
  @$pb.TagNumber(11)
  void clearHighestPowerPlayPoints() => clearField(11);

  @$pb.TagNumber(12)
  $core.double get soloVictories => $_getN(10);
  @$pb.TagNumber(12)
  set soloVictories($core.double v) { $_setDouble(10, v); }
  @$pb.TagNumber(12)
  $core.bool hasSoloVictories() => $_has(10);
  @$pb.TagNumber(12)
  void clearSoloVictories() => clearField(12);

  @$pb.TagNumber(13)
  $core.double get duoVictories => $_getN(11);
  @$pb.TagNumber(13)
  set duoVictories($core.double v) { $_setDouble(11, v); }
  @$pb.TagNumber(13)
  $core.bool hasDuoVictories() => $_has(11);
  @$pb.TagNumber(13)
  void clearDuoVictories() => clearField(13);

  @$pb.TagNumber(14)
  $core.double get bestRoboRumbleTime => $_getN(12);
  @$pb.TagNumber(14)
  set bestRoboRumbleTime($core.double v) { $_setDouble(12, v); }
  @$pb.TagNumber(14)
  $core.bool hasBestRoboRumbleTime() => $_has(12);
  @$pb.TagNumber(14)
  void clearBestRoboRumbleTime() => clearField(14);

  @$pb.TagNumber(15)
  $core.double get bestTimeAsBigBrawler => $_getN(13);
  @$pb.TagNumber(15)
  set bestTimeAsBigBrawler($core.double v) { $_setDouble(13, v); }
  @$pb.TagNumber(15)
  $core.bool hasBestTimeAsBigBrawler() => $_has(13);
  @$pb.TagNumber(15)
  void clearBestTimeAsBigBrawler() => clearField(15);

  @$pb.TagNumber(16)
  $core.List<Player_BRAWLERS> get brawlers => $_getList(14);

  @$pb.TagNumber(17)
  $core.String get nameColor => $_getSZ(15);
  @$pb.TagNumber(17)
  set nameColor($core.String v) { $_setString(15, v); }
  @$pb.TagNumber(17)
  $core.bool hasNameColor() => $_has(15);
  @$pb.TagNumber(17)
  void clearNameColor() => clearField(17);
}

