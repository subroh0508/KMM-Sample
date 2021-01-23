import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    let idols = ["浅倉透", "樋口円香", "市川雛菜", "福丸小糸"]

    var body: some View {
        NavigationView {
            List()
        }
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
