import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        ComposeApp.Helper().doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
			ContentView()
		}
	}
}
