import Flutter
import UIKit
import Platform

public class SwiftBatterylevelPlugin: NSObject, FlutterPlugin {
  public static func register(with registrar: FlutterPluginRegistrar) {
    let channel = FlutterMethodChannel(name: "com.example.batterylevel", binaryMessenger: registrar.messenger())
    let instance = SwiftBatterylevelPlugin()
    registrar.addMethodCallDelegate(instance, channel: channel)
  }

  public func handle(_ call: FlutterMethodCall, result: @escaping FlutterResult) {
    switch call.method {
       case "getBatteryLevel":
            self.getBatteryLevel(result: result)
        default:
            result(FlutterMethodNotImplemented)
        }
  }

    func getBatteryLevel(result: @escaping FlutterResult) {
        result(Platform().getBatteryLevel(context: ""))
    }  
}
