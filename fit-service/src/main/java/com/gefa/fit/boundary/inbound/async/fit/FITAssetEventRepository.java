package com.gefa.fit.boundary.inbound.async.fit;

import com.gefa.fit.boundary.inbound.async.fit.domain.FITAssetEvent;

public interface FITAssetEventRepository {

	FITAssetEvent getEvent();
}
