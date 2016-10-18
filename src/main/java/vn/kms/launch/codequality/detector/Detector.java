package vn.kms.launch.codequality.detector;

import java.util.List;

import vn.kms.launch.codequality.model.InvalidDetail;

public interface Detector {
	List<InvalidDetail> findInvalidDetails(Object object);
}
