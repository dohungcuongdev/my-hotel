package vn.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.daos.AdditionalPaymentDAO;
import vn.daos.impl.AdditionalPaymentDAOImpl;
import vn.model.AdditionalPayment;
import vn.service.AdditionalPaymentService;

/**
*
* @author HUNGCUONG
*/

@Service
public class AdditionalPaymentServiceImpl implements AdditionalPaymentService {
	
	@Autowired
	private AdditionalPaymentDAO additionalPaymentDAO = new AdditionalPaymentDAOImpl();
	
	@Override
	public List<AdditionalPayment> getAllAdditionalPayments() {
		return additionalPaymentDAO.getAllAdditionalPayments();
	}
	
	@Override
	public AdditionalPayment getSingleAdditionalPayment(String additionDetails) {
		return additionalPaymentDAO.getSingleAdditionalPayment(additionDetails);
	}
	
	@Override
	public void deSelectAdditionalPayment(int id) {
		additionalPaymentDAO.deSelectAdditionalPayment(id);
	}
	
	@Override
	public void selectAdditionalPayment(int id) {
		additionalPaymentDAO.selectAdditionalPayment(id);
	}
	
	@Override
	public AdditionalPayment getSelectedAdditionalPayment() {
		return additionalPaymentDAO.getSelectedAdditionalPayment();
	}

	@Override
	public boolean isExists(AdditionalPayment additionalPayment) {
		return additionalPaymentDAO.isExists(additionalPayment);
	}

	@Override
	public int findIDAndAddNewAdditionalPayment(AdditionalPayment additionalPayment) {
		return additionalPaymentDAO.findIDAndAddNewAdditionalPayment(additionalPayment);
	}

	@Override
	public int findIDAndAddNewAdditionalPayment(String additionDetails, int additionalNormalRoomPrice,
			int additionalVIPRoomPrice, int additionalNormalHourPrice, int additionalVIPHourPrice,
			int additionalNormalNightPrice, int additionalVIPNightPrice, boolean selected) {
		return additionalPaymentDAO.findIDAndAddNewAdditionalPayment(additionDetails, additionalNormalRoomPrice, additionalVIPRoomPrice, additionalNormalHourPrice, additionalVIPHourPrice, additionalNormalNightPrice, additionalVIPNightPrice, selected);
	}
}
