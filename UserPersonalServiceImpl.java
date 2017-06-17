package com.hcss.serviceImpl;

import java.util.Vector;
import com.hcss.bean.DrugsTo;
import com.hcss.bean.BankTO;
import com.hcss.bean.DrivingLicenseTO;
import com.hcss.bean.EducationTO;
import com.hcss.bean.InsuranceTO;
import com.hcss.bean.MailsTO;
import com.hcss.bean.PancardTO;
import com.hcss.bean.PassportTO;
import com.hcss.bean.ReviewBean;
import com.hcss.bean.ReviewTO;
import com.hcss.bean.UserImpFilesTO;
import com.hcss.daoI.UserPersonalDaoI;
import com.hcss.daoImpl.UserPersonalDaoImpl;
import com.hcss.exception.ConnectionException;
import com.hcss.servicei.UserPersonalServiceI;

public class UserPersonalServiceImpl implements UserPersonalServiceI {

	UserPersonalDaoI userPersonalDaoI = new UserPersonalDaoImpl();

	public boolean addEducationDetails(EducationTO educationTO)
			throws ConnectionException {
		String[] extension = educationTO.getScanedmemo1().split("\\.");
		int i;
		for (i = 0; i < extension.length; i++) {
			educationTO.setMemotype(extension[i]);
		}
		return userPersonalDaoI.addEducationDetails(educationTO);
	}

	public boolean addBankDetails(BankTO bankTO) throws ConnectionException {
		return userPersonalDaoI.addBankDetails(bankTO);
	}

	public boolean addDrugsDetails(DrugsTo bankTO) throws ConnectionException {
		return userPersonalDaoI.addDrugsDetails(bankTO);
	}

	public boolean postDrugsReview(ReviewTO reviewTO)
			throws ConnectionException {
		return userPersonalDaoI.postDrugReview(reviewTO);
	}

	public boolean addUserImpFiles(UserImpFilesTO userImpFilesTO)
			throws ConnectionException {
		String[] extension = userImpFilesTO.getFiledatapath().split("\\.");
		int i;
		for (i = 0; i < extension.length; i++) {
			userImpFilesTO.setFiletype(extension[i]);
		}
		return userPersonalDaoI.addUserImpFiles(userImpFilesTO);
	}

	public boolean addInsuranceDetails(InsuranceTO insuranceTO)
			throws ConnectionException {
		return userPersonalDaoI.addInsuranceDetails(insuranceTO);
	}

	public boolean addLicenseDetails(DrivingLicenseTO drivingLicenseTO)
			throws ConnectionException {
		return userPersonalDaoI.addLicenseDetails(drivingLicenseTO);
	}

	public boolean addMailsDetails(MailsTO mailsTO) throws ConnectionException {
		return userPersonalDaoI.addMailsDetails(mailsTO);
	}

	public boolean addPancardDetails(PancardTO pancardTO)
			throws ConnectionException {
		return userPersonalDaoI.addPancardDetails(pancardTO);
	}

	public boolean addPassportDetails(PassportTO pancardTO)
			throws ConnectionException {
		return userPersonalDaoI.addPassportDetails(pancardTO);
	}

	public Vector<UserImpFilesTO> viewUserImpFiles(String path, int userid)
			throws ConnectionException {
		return userPersonalDaoI.viewUserImpFiles(path, userid);
	}

	public Vector<PancardTO> viewPancardDetails(int userid)
			throws ConnectionException {
		return userPersonalDaoI.viewPancardDetails(userid);
	}

	public Vector<PassportTO> viewPassportDetails(int userid)
			throws ConnectionException {
		return userPersonalDaoI.viewPassportDetails(userid);
	}

	public Vector<MailsTO> viewMailsDetails(int userid)
			throws ConnectionException {
		return userPersonalDaoI.viewMailsDetails(userid);
	}

	public Vector<DrivingLicenseTO> viewLicenseDetails(int userid)
			throws ConnectionException {
		return userPersonalDaoI.viewLicenseDetails(userid);
	}

	public Vector<InsuranceTO> viewInsurenceDetails(int userid)
			throws ConnectionException {
		return userPersonalDaoI.viewInsurenceDetails(userid);
	}

	public Vector<BankTO> viewBankDetails(int userid)
			throws ConnectionException {
		return userPersonalDaoI.viewBankDetails(userid);
	}

	public Vector<DrugsTo> viewDrugDetails(int userid)
			throws ConnectionException {
		return userPersonalDaoI.viewDrugDetails(userid);
	}

	public Vector<DrugsTo> viewDrugSummary() throws ConnectionException {
		return userPersonalDaoI.viewDrugSummary();
	}

	public Vector<ReviewTO> viewDrugReview() throws ConnectionException {
		return userPersonalDaoI.viewDrugReview();
	}

	public Vector<ReviewTO> DrugReview() throws ConnectionException {
		return userPersonalDaoI.DrugReview();
	}

	public Vector<ReviewTO> DrugsReview() throws ConnectionException {
		return userPersonalDaoI.DrugsReview();
	}

	public Vector<ReviewTO> RSWDrugsReview() throws ConnectionException {
		return userPersonalDaoI.RSWDrugsReview();
	}

	public Vector<ReviewTO> LBDrugsReview() throws ConnectionException {
		return userPersonalDaoI.LBDrugsReview();
	}

	public Vector<ReviewTO> GBDrugsReview() throws ConnectionException {
		return userPersonalDaoI.GBDrugsReview();
	}
	public Vector<ReviewTO> GBDrugsReview1() throws ConnectionException {
		return userPersonalDaoI.GBDrugsReview1();
	}
	public Vector<ReviewTO> GBDrugsReview2() throws ConnectionException {
		return userPersonalDaoI.GBDrugsReview2();
	}

	public Vector<ReviewBean> ABDrugsReview() throws ConnectionException {
		return userPersonalDaoI.ABDrugsReview();
	}
	public Vector<ReviewBean> ABDrugsReview1() throws ConnectionException {
		return userPersonalDaoI.ABDrugsReview1();
	}
	public Vector<ReviewTO> LBCDrugsReview() throws ConnectionException {
		return userPersonalDaoI.LBCDrugsReview();
	}
	public Vector<ReviewTO> LBCDrugsReview1() throws ConnectionException {
		return userPersonalDaoI.LBCDrugsReview1();
	}

	public Vector<ReviewTO> CWDrugsReview() throws ConnectionException {
		return userPersonalDaoI.CountDrugsReview();
	}
	public Vector<ReviewBean> ECWDrugsReview() throws ConnectionException {
		return userPersonalDaoI.ECountDrugsReview();
	}
	public Vector<DrugsTo> viewDrugDetails(String data)
			throws ConnectionException {
		return userPersonalDaoI.viewDrugDetails(data);
	}

	public Vector<EducationTO> viewEducationDetails(String path, int userid)
			throws ConnectionException {
		return userPersonalDaoI.viewEducationDetails(path, userid);
	}

	public boolean deleteItem(int record, String delete)
			throws ConnectionException {
		return userPersonalDaoI.deleteItem(record, delete);
	}

	public EducationTO updateViewEducationDetails(String path, int educationid)
			throws ConnectionException {
		return userPersonalDaoI.updateViewEducationDetails(path, educationid);
	}

	public boolean updateEducationDetails(EducationTO educationTO)
			throws ConnectionException {
		System.out.println(educationTO.getScanedmemo1());
		String[] extension = educationTO.getScanedmemo1().split("\\.");
		int i;
		for (i = 0; i < extension.length; i++) {
			System.out.println(extension[i]);
			educationTO.setMemotype(extension[i]);
		}
		return userPersonalDaoI.updateEducationDetails(educationTO);
	}

	public BankTO updateViewBankDetails(int bankid) throws ConnectionException {
		return userPersonalDaoI.updateViewBankDetails(bankid);
	}

	public DrugsTo updateViewDrugDetails(int bankid) throws ConnectionException {
		return userPersonalDaoI.updateViewDrugDetails(bankid);
	}

	public boolean updateBankDetails(BankTO bankTO) throws ConnectionException {
		return userPersonalDaoI.updateBankDetails(bankTO);
	}

	public boolean updateDrugDetails(DrugsTo bankTO) throws ConnectionException {
		return userPersonalDaoI.updateDrugDetails(bankTO);
	}

	public MailsTO viewUpdateMailsDetails(int mailid)
			throws ConnectionException {
		return userPersonalDaoI.viewUpdateMailsDetails(mailid);
	}

	public boolean updateMailsDetails(MailsTO mailsTO)
			throws ConnectionException {
		return userPersonalDaoI.updateMailsDetails(mailsTO);
	}

	public PassportTO viewUpdatePassPortDetails(int passportid)
			throws ConnectionException {
		return userPersonalDaoI.viewUpdatePassPortDetails(passportid);
	}

	public boolean updatePassportDetails(PassportTO passportTO)
			throws ConnectionException {
		return userPersonalDaoI.updatePassportDetails(passportTO);
	}

	public InsuranceTO viewUpdateInsurenceDetails(int insuranceid)
			throws ConnectionException {
		return userPersonalDaoI.viewUpdateInsurenceDetails(insuranceid);
	}

	public UserImpFilesTO viewUpdateUserFiles(String path, int fileid)
			throws ConnectionException {
		// TODO Auto-generated method stub
		return userPersonalDaoI.viewUpdateUserFiles(path, fileid);
	}

	public PancardTO viewUpdatePanDetails(int panid) throws ConnectionException {
		return userPersonalDaoI.viewUpdatePanDetails(panid);
	}

	public DrivingLicenseTO viewUpdateLicenseDetails(int licenseid)
			throws ConnectionException {
		return userPersonalDaoI.viewUpdateLicenseDetails(licenseid);
	}

	public boolean updatePancardDetails(PancardTO pancardTO)
			throws ConnectionException {
		return userPersonalDaoI.updatePancardDetails(pancardTO);
	}

	public boolean updateLicenseDetails(DrivingLicenseTO drivingLicenseTO)
			throws ConnectionException {
		return userPersonalDaoI.updateLicenseDetails(drivingLicenseTO);

	}

	public boolean updateInsurenceDetails(InsuranceTO insuranceTO)
			throws ConnectionException {
		return userPersonalDaoI.updateInsurenceDetails(insuranceTO);

	}

	public boolean updateUserFilesDetails(UserImpFilesTO userImpFilesTO)
			throws ConnectionException {
		String[] extension = userImpFilesTO.getFiledatapath().split("\\.");
		int i;
		for (i = 0; i < extension.length; i++) {
			userImpFilesTO.setFiletype(extension[i]);
		}
		return userPersonalDaoI.addUserImpFiles(userImpFilesTO);
	}
}
