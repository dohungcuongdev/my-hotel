package vn.daos;

import java.util.List;

import vn.model.AdditionalPayment;

public interface AdditionalPaymentDAO {
	public List<AdditionalPayment> getAllAdditionalPayments();
	public AdditionalPayment getSingleAdditionalPayment(String additionDetails);
}
