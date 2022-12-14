/******************************************************************************
 * File: PermissionUtil.java
 * Copyright (c) 2021 Qualcomm Technologies, Inc. and/or its subsidiaries. All rights reserved.
 *  2019-2021 Wikitude GmbH.
 * 
 * Confidential and Proprietary - Qualcomm Technologies, Inc.
 *
 ******************************************************************************/

package com.wikitude.wikitude_plugin;

import android.Manifest;

import com.wikitude.common.devicesupport.Feature;

import java.util.EnumSet;

class PermissionUtil {

    private PermissionUtil(){}

    static String[] getPermissionsForArFeatures(EnumSet<Feature> features) {
        return (features.contains(Feature.GEO)) ?
                new String[]{Manifest.permission.CAMERA, Manifest.permission.ACCESS_FINE_LOCATION} :
                new String[]{Manifest.permission.CAMERA};
    }

    static StringBuilder getPermissionErrorText(String[] permissions) {
        StringBuilder permissionsRejected = new StringBuilder();
        permissionsRejected.append("Permissions required: \n");
        for (String permission : permissions) {
            permissionsRejected.append(permission).append("\n");
        }
        return permissionsRejected;
    }
}
