package vn.daos;

import java.util.List;

import vn.model.AdditionalPayment;

public interface AdditionalPaymentDAO {
	public List<AdditionalPayment> getAllAdditionalPayments();
	public AdditionalPayment getSingleAdditionalPayment(String additionDetails);
	public void deSelectAdditionalPayment(int id);
	public void selectAdditionalPayment(int id);
	public AdditionalPayment getSelectedAdditionalPayment();
	public boolean isExists (AdditionalPayment additionalPayment);
	public int findIDAndAddNewAdditionalPayment(AdditionalPayment additionalPayment);
	public int findIDAndAddNewAdditionalPayment(String additionDetails, int additionalNormalRoomPrice, int additionalVIPRoomPrice,
			int additionalNormalHourPrice, int additionalVIPHourPrice, int additionalNormalNightPrice,
			int additionalVIPNightPrice, boolean selected);
}
