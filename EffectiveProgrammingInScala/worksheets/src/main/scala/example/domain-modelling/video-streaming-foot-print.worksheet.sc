enum VideoQuality:
  case High, Low

def definition(videoQuality: VideoQuality) = videoQuality match 
  case VideoQuality.High => 0.6
  case VideoQuality.Low => 0.3

enum Network:
  case Mobile, Fixed

def networkEnergy(network: Network) = network match
  case Network.Mobile => 0.00088
  case Network.Fixed => 0.00043

val duration = 30 * 60

val dataCenterEnergy = 0.000072

val kgCO2PerkWh = 0.5

def footPrint(videoQuality: VideoQuality, network: Network) =
  val megabytes = definition(videoQuality) * duration
  val energy = networkEnergy(network) + dataCenterEnergy
  megabytes * energy * kgCO2PerkWh

footPrint(VideoQuality.Low, Network.Fixed)
footPrint(VideoQuality.High, Network.Mobile)
