package com.yilan.distributed.sequence;

/**
 * Created by sunyujia@aliyun.com on 2016/2/25.
 */
public interface DistributedSequence {

    Long sequence(String sequenceName);
}
