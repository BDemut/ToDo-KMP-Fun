import SwiftUI
import ComposeApp

@main
struct iOSApp: App {
    init() {
        ComposeApp.KoinHelperKt.doInitKoin()
    }

	var body: some Scene {
		WindowGroup {
            ContentView().edgesIgnoringSafeArea(/*@START_MENU_TOKEN@*/.all/*@END_MENU_TOKEN@*/)
		}
	}
}
