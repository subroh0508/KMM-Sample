//
//  MainViewController.swift
//  ios
//
//  Created by にしこりさぶろ〜 on 2021/01/24.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import shared

class MainViewController: UIViewController, UISearchBarDelegate {
    @IBOutlet weak var searchBar: UISearchBar!
    @IBOutlet weak var collectionView: UICollectionView!
    
    let idols = [
        Idol(id: "Asakura_Toru", name: "浅倉透", yomi: "あさくらとおる", color: "#50D0D0", age: 17, birthplace: "東京", hobbies: ["映画やドラマを見ること"], idollistUrl: "https://idollist.idolmaster-official.jp/detail/50001"),
        Idol(id: "Higuchi_Madoka", name: "樋口円香", yomi: "ひぐちまどか", color: "#BE1E3E", age: 17, birthplace: "東京", hobbies: ["別にないです"], idollistUrl: "https://idollist.idolmaster-official.jp/detail/50018"),
        Idol(id: "Fukumaru_Koito", name: "福丸小糸", yomi: "ふくまるこいと", color: "#7967C3", age: 16, birthplace: "東京", hobbies: ["読書"], idollistUrl: "https://idollist.idolmaster-official.jp/detail/50019"),
        Idol(id: "Ichikawa_Hinana", name: "市川雛菜", yomi: "いちかわひなな", color: "#FFC639", age: 15, birthplace: "神奈川", hobbies: ["なんでもそれなりに好き～"], idollistUrl: "https://idollist.idolmaster-official.jp/detail/50004"),
    ]
    
    override func viewDidLoad() {
        super.viewDidLoad()

        searchBar.delegate = self

        collectionView.register(UINib(nibName: "IdolCollectionCell", bundle: nil), forCellWithReuseIdentifier: "IdolCollectionCell")
        collectionView.dataSource = self

        let flowLayout = UICollectionViewFlowLayout()
        flowLayout.itemSize = CGSize(width: UIScreen.main.bounds.width, height: 82)
        flowLayout.minimumLineSpacing = 0
        collectionView.collectionViewLayout = flowLayout
    }
    
    func searchBarSearchButtonClicked(_ searchBar: UISearchBar) {
        view.endEditing(true)

        if let word = searchBar.text {
            print(word)
        }
    }
}

extension MainViewController : UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return idols.count
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "IdolCollectionCell", for: indexPath)

        if let cell = cell as? IdolCollectionCell {
            cell.bind(item: idols[indexPath.row])
        }

        return cell
    }
}
