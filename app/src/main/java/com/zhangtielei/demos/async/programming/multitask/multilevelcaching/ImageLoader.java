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

package com.zhangtielei.demos.async.programming.multitask.multilevelcaching;

/**
 * Created by Tielei Zhang on 16/5/17.
 * 一个简单的图片加载器.
 * 两级Cache: memory cache, disk cache; 如果都没有命中, 则调用Downloader去下载.
 * 注意: 这个实现只是一个Demo, 为了演示多级缓存用.
 */
public interface ImageLoader {
    /**
     * 设置回调监听器.
     * @param listener
     */
    void setListener(ImageLoaderListener listener);
    /**
     * 根据指定Url启动图片加载.
     * @param url 要下载的资源地址.
     * @param contextData 上下文数据, 在回调接口中会透传回去.可以是任何类型.
     */
    void startImageLoad(String url, Object contextData);
}
