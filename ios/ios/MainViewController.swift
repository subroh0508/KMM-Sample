//
//  MainViewController.swift
//  ios
//
//  Created by にしこりさぶろ〜 on 2021/01/24.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit

class MainViewController: UIViewController, UISearchBarDelegate {
    @IBOutlet weak var searchBar: UISearchBar!

    override func viewDidLoad() {
        super.viewDidLoad()

        searchBar.delegate = self
    }
    
    func searchBarSearchButtonClicked(_ searchBar: UISearchBar) {
        view.endEditing(true)

        if let word = searchBar.text {
            print(word)
        }
    }
}
