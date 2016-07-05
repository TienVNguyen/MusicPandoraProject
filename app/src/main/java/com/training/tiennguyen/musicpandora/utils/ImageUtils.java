/*
 * Copyright (c) 2016. Self Training Systems, Inc - All Rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Written by TienNguyen <tien.workinfo@gmail.com - tien.workinfo@icloud.com>, October 2015
 */

package com.training.tiennguyen.musicpandora.utils;

import android.app.Activity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * ImageUtils
 *
 * @author TienNguyen
 */
public class ImageUtils {
    public static void setImage(Activity activity, String imageValue, int targetWidth, int targetHeight, ImageView imageView) {
        Picasso.with(activity)
                .load(imageValue)
                .resize(targetWidth, targetHeight)
                .centerCrop()
                .into(imageView);
    }
}
