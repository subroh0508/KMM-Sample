//
//  IdolCollectionCell.swift
//  ios
//
//  Created by にしこりさぶろ〜 on 2021/01/24.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import shared

class IdolCollectionCell: UICollectionViewCell {
    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var yomi: UILabel!

    func bind(item: Idol) {
        self.name.text = item.name
        self.yomi.text = item.yomi
    }
}
