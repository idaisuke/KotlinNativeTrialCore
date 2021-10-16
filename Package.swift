// swift-tools-version:5.5
// The swift-tools-version declares the minimum version of Swift required to build this package.

import PackageDescription

let package = Package(
        name: "KotlinNativeTrialCore",
        products: [.library(
                name: "KotlinNativeTrialCore",
                targets: ["KotlinNativeTrialCore"]
        )],
        targets: [.binaryTarget(
                name: "KotlinNativeTrialCore",
                path: "xcframework/KotlinNativeTrialCore.xcframework"
        )]
)
