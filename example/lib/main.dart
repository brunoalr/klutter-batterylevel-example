import 'package:flutter/material.dart';
import 'dart:async';

import 'package:batterylevel/batterylevel.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatefulWidget {
  const MyApp({Key? key}) : super(key: key);

  @override
  State<MyApp> createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {

  @override
  void initState() {
    super.initState();
  }

  String _batteryLevel = '...';

  Future<void> _getBatteryLevel() async {
    await Batterylevel.getBatteryLevel(this,
      onSuccess: (level) => setState(() {
        _batteryLevel = "Battery level at $level%.";
      }),
      onFailure: (exception) => setState(() {
        _batteryLevel = "Failed to get battery level: $exception.";
      }),
      onNullValue: () => setState(() {
        _batteryLevel = "Unknown battery level.";
      }),
    );
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        appBar: AppBar(
          title: const Text('BatteryLevel Example'),
        ),
        body: Center(
          child: Column(
            mainAxisAlignment: MainAxisAlignment.spaceEvenly,
            children: [
              ElevatedButton(
                onPressed: _getBatteryLevel,
                child: const Text('Get Battery Level'),
              ),
              Text(_batteryLevel),
            ],
          ),
        ),
      ),
    );
  }

}

