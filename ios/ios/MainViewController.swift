//
//  MainViewController.swift
//  ios
//
//  Created by にしこりさぶろ〜 on 2021/01/24.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import iosArtifacts

class MainViewController: UIViewController, UISearchBarDelegate {
    private let di = IdolsViewModelDIKt.IdolsViewModelDI(modules: [Main().Module])
    
    @IBOutlet weak var searchBar: UISearchBar!
    @IBOutlet weak var collectionView: UICollectionView!
    
    private var uiModel = IdolsUiModel(items: [], query: nil)
    private var viewModel: IdolsViewModel!

    override func viewDidLoad() {
        super.viewDidLoad()

        viewModel = NativeDIKt.createViewModel(di: di)

        searchBar.delegate = self

        collectionView.register(UINib(nibName: "IdolCollectionCell", bundle: nil), forCellWithReuseIdentifier: "IdolCollectionCell")
        collectionView.dataSource = self

        let flowLayout = UICollectionViewFlowLayout()
        flowLayout.itemSize = CGSize(width: UIScreen.main.bounds.width, height: 82)
        flowLayout.minimumLineSpacing = 0
        collectionView.collectionViewLayout = flowLayout

        viewModel.getUiModel { uiModel in
            print(uiModel)
            self.uiModel = uiModel
            self.collectionView.reloadData()
        }

        viewModel.search(query: "")
    }
    
    func searchBarSearchButtonClicked(_ searchBar: UISearchBar) {
        view.endEditing(true)

        if let word = searchBar.text {
            print(word)
            viewModel.search(query: word)
        }
    }
}

extension MainViewController : UICollectionViewDataSource {
    func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        return uiModel.items.count
    }

    func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "IdolCollectionCell", for: indexPath)

        if let cell = cell as? IdolCollectionCell {
            cell.bind(item: uiModel.items[indexPath.row])
        }

        return cell
    }
}
