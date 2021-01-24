//
//  IdolCollectionCell.swift
//  ios
//
//  Created by にしこりさぶろ〜 on 2021/01/24.
//  Copyright © 2021 orgName. All rights reserved.
//

import UIKit
import iosArtifacts

class IdolCollectionCell: UICollectionViewCell {
    @IBOutlet weak var name: UILabel!
    @IBOutlet weak var yomi: UILabel!
    
    func bind(item: Idol) {
        self.name.text = item.name

        let border = CALayer()
        border.frame = CGRect(x: 0, y: self.name.frame.height - 1, width: UIScreen.main.bounds.width - 32, height: 1)
        border.backgroundColor = hexToUIColor(hex: item.color).cgColor
        
        self.name.layer.addSublayer(border)
        self.yomi.text = item.yomi
    }

    private func hexToUIColor(hex: String) -> UIColor {
        var cString: String = hex.trimmingCharacters(in: .whitespacesAndNewlines).uppercased()

        if (cString.hasPrefix("#")) {
            cString.remove(at: cString.startIndex)
        }

        if ((cString.count) != 6) {
            return UIColor.gray
        }

        var rgbValue: UInt64 = 0
        Scanner(string: cString).scanHexInt64(&rgbValue)

        return UIColor(
            red: CGFloat((rgbValue & 0xFF0000) >> 16) / 255.0,
            green: CGFloat((rgbValue & 0x00FF00) >> 8) / 255.0,
            blue: CGFloat(rgbValue & 0x0000FF) / 255.0,
            alpha: CGFloat(1.0)
        )
    }
}
