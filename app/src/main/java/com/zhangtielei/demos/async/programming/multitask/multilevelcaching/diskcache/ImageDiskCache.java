/*
 * Copyright (C) 2016 Tielei Zhang (zhangtielei.com).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.zhangtielei.demos.async.programming.multitask.multilevelcaching.diskcache;

import android.graphics.Bitmap;
import com.zhangtielei.demos.async.programming.common.AsyncCallback;

/**
 * Created by Tielei Zhang on 16/5/17.
 *
 * 图片的Disk缓存.
 * 异步接口形式.
 */
public interface ImageDiskCache {
    /**
     * 异步获取缓存的Bitmap对象.
     * @param key
     * @param callback 用于返回缓存的Bitmap对象
     */
    void getImage(String key, AsyncCallback<Bitmap> callback);
    /**
     * 保存Bitmap对象到缓存中.
     * @param key
     * @param bitmap 要保存的Bitmap对象
     * @param callback 用于返回当前保存操作的结果是成功还是失败.
     */
    void putImage(String key, Bitmap bitmap, AsyncCallback<Boolean> callback);
}
