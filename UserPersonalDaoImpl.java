package com.hcss.daoImpl;

import java.io.File;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.Date;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
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
import com.hcss.dao.AbstractDBFactory;
import com.hcss.daoI.UserPersonalDaoI;
import com.hcss.exception.ConnectionException;
import com.hcss.utill.DateWrapper;

public class UserPersonalDaoImpl implements UserPersonalDaoI {
	boolean flag = false;
	Session session = null;

	public boolean addEducationDetails(EducationTO educationTo)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			System.out.println(educationTo.getScanedmemo1());
			File f = new File(educationTo.getScanedmemo1());
			byte[] personByteArray = new byte[(int) f.length()];
			Blob b = Hibernate.createBlob(personByteArray);

			FileInputStream fileInputStream = new FileInputStream(f);
			fileInputStream.read(personByteArray);
			fileInputStream.close();

			educationTo.setScanedmemo(b);
			session.save(educationTo);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean updateEducationDetails(EducationTO educationTo)
			throws ConnectionException {
		try {
			System.out.println("haiiiiiii");
			System.out.println(educationTo.getScanedmemo1());
			System.out.println(educationTo.getMemotype());
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			File f = new File(educationTo.getScanedmemo1());
			byte[] personByteArray = new byte[(int) f.length()];
			Blob b = Hibernate.createBlob(personByteArray);

			FileInputStream fileInputStream = new FileInputStream(f);
			fileInputStream.read(personByteArray);
			fileInputStream.close();

			educationTo.setScanedmemo(b);
			EducationTO educationTO2 = (EducationTO) session.get(
					EducationTO.class,
					new Integer(educationTo.getEducationid()));

			educationTO2.setEducationname(educationTo.getEducationname());
			educationTO2.setHallticketno(educationTo.getHallticketno());
			educationTO2.setYearofpass(educationTo.getYearofpass());
			educationTO2.setAggregation(educationTo.getAggregation());
			educationTO2.setPercentage(educationTo.getPercentage());
			educationTO2.setTotalmarks(educationTo.getTotalmarks());
			educationTO2.setScanedmemo(educationTo.getScanedmemo());
			educationTO2.setMemotype(educationTo.getMemotype());

			session.update(educationTO2);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean addBankDetails(BankTO bankTO) throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			bankTO.setBankid(1);
			session.save(bankTO);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean addDrugsDetails(DrugsTo drugTo) throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			drugTo.setDid(1);
			session.save(drugTo);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean postDrugReview(ReviewTO reviewTO) throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			reviewTO.setRid(1);
			session.save(reviewTO);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean updateBankDetails(BankTO bankTO) throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			BankTO bankTO2 = (BankTO) session.get(BankTO.class, new Integer(
					bankTO.getBankid()));

			bankTO2.setBankName(bankTO.getBankName());
			bankTO2.setBranchName(bankTO.getBranchName());
			bankTO2.setAccnumber(bankTO.getAccnumber());
			bankTO2.setUsername(bankTO.getUsername());
			bankTO2.setPassword(bankTO.getPassword());
			bankTO2.setAtmcardno(bankTO.getAtmcardno());
			bankTO2.setAtmpin(bankTO.getAtmpin());
			bankTO2.setSiteurl(bankTO.getSiteurl());

			session.update(bankTO2);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problum Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean updateDrugDetails(DrugsTo drugTo) throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			DrugsTo drugsTo = (DrugsTo) session.get(DrugsTo.class, new Integer(
					drugTo.getDid()));
			drugsTo.setDrugName(drugTo.getDrugName());
			drugsTo.setBrandName(drugTo.getBrandName());
			drugsTo.setUsage(drugTo.getUsage());
			session.update(drugsTo);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean addUserImpFiles(UserImpFilesTO userImpFilesTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			File f = new File(userImpFilesTO.getFiledatapath());
			byte[] personByteArray = new byte[(int) f.length()];
			Blob b = Hibernate.createBlob(personByteArray);

			FileInputStream fileInputStream = new FileInputStream(f);
			fileInputStream.read(personByteArray);
			fileInputStream.close();
			userImpFilesTO.setFiledata(b);
			session.save(userImpFilesTO);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean addInsuranceDetails(InsuranceTO insuranceTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction transaction = session.beginTransaction();
			insuranceTO.setInsurenceid(1);
			insuranceTO.setPremiumdate(DateWrapper.parseDate(insuranceTO
					.getPremiumdate()));
			session.save(insuranceTO);
			transaction.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean addLicenseDetails(DrivingLicenseTO drivingLicenseTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction transaction = session.beginTransaction();
			drivingLicenseTO.setLiesenceid(1);
			drivingLicenseTO.setIssueddate(DateWrapper
					.parseDate(drivingLicenseTO.getIssueddate()));
			drivingLicenseTO.setValiddate(DateWrapper
					.parseDate(drivingLicenseTO.getValiddate()));
			session.save(drivingLicenseTO);
			transaction.commit();
			flag = true;
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean addMailsDetails(MailsTO mailsTO) throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			mailsTO.setMailid(1);
			session.save(mailsTO);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean addPancardDetails(PancardTO pancardTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			pancardTO.setPanid(1);
			System.out.println(pancardTO.getIssuedate());
			pancardTO.setIssuedate(DateWrapper.parseDate(pancardTO
					.getIssuedate()));
			session.save(pancardTO);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean addPassportDetails(PassportTO passportTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			passportTO.setPassportid(1);
			passportTO.setIssueddate(DateWrapper.parseDate(passportTO
					.getIssueddate()));
			passportTO.setValiditydate(DateWrapper.parseDate(passportTO
					.getValiditydate()));
			session.save(passportTO);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public Vector<UserImpFilesTO> viewUserImpFiles(String path, int userid)
			throws ConnectionException {
		UserImpFilesTO userImpFilesTO = null;
		Vector<UserImpFilesTO> vUserImpFilesTOs = new Vector<UserImpFilesTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from UserImpFilesTO userImpFiles where userImpFiles.useridref=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, userid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				String realpath = "";
				userImpFilesTO = (UserImpFilesTO) it.next();
				Blob b = userImpFilesTO.getFiledata();
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = path + "/" + userImpFilesTO.getFileid() + "."
						+ userImpFilesTO.getFiletype();
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				userImpFilesTO.setFiledatapath(realpath);
				vUserImpFilesTOs.add(userImpFilesTO);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vUserImpFilesTOs;
	}

	public Vector<PancardTO> viewPancardDetails(int userid)
			throws ConnectionException {
		PancardTO pancardTO = null;
		Vector<PancardTO> vPancardTOs = new Vector<PancardTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from PancardTO pancard where pancard.useridref=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, userid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				pancardTO = (PancardTO) it.next();
				pancardTO.setIssuedate(pancardTO.getIssuedate()
						.substring(0, 10));
				vPancardTOs.add(pancardTO);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vPancardTOs;
	}

	public Vector<PassportTO> viewPassportDetails(int userid)
			throws ConnectionException {
		PassportTO passportTO = null;
		Vector<PassportTO> vPassportTOs = new Vector<PassportTO>();
		try {
			System.out.println("hsiiiiiii");
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from PassportTO passport where passport.useridref=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, userid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				passportTO = (PassportTO) it.next();
				passportTO.setIssueddate(DateWrapper.parseDate(passportTO
						.getIssueddate().substring(0, 10)));
				passportTO.setValiditydate(DateWrapper.parseDate(passportTO
						.getValiditydate().substring(0, 10)));
				vPassportTOs.add(passportTO);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vPassportTOs;
	}

	public Vector<MailsTO> viewMailsDetails(int userid)
			throws ConnectionException {
		MailsTO mailsTO = null;
		Vector<MailsTO> vmailsTOs = new Vector<MailsTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from MailsTO mail where mail.useridref=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, userid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				mailsTO = (MailsTO) it.next();
				vmailsTOs.add(mailsTO);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vmailsTOs;
	}

	public Vector<DrivingLicenseTO> viewLicenseDetails(int userid)
			throws ConnectionException {
		DrivingLicenseTO drivingLicenseTO = null;
		Vector<DrivingLicenseTO> vDrivingLicenseTOs = new Vector<DrivingLicenseTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from DrivingLicenseTO drivingLicense where drivingLicense.useridref=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, userid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				drivingLicenseTO = (DrivingLicenseTO) it.next();
				drivingLicenseTO.setIssueddate(DateWrapper
						.parseDate(drivingLicenseTO.getIssueddate().substring(
								0, 10)));
				drivingLicenseTO.setValiddate(DateWrapper
						.parseDate(drivingLicenseTO.getValiddate().substring(0,
								10)));
				vDrivingLicenseTOs.add(drivingLicenseTO);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vDrivingLicenseTOs;
	}

	public Vector<InsuranceTO> viewInsurenceDetails(int userid)
			throws ConnectionException {
		InsuranceTO insuranceTO = null;
		Vector<InsuranceTO> vInsuranceTOs = new Vector<InsuranceTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from InsuranceTO insurance where insurance.useridref=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, userid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				insuranceTO = (InsuranceTO) it.next();
				insuranceTO.setPremiumdate(insuranceTO.getPremiumdate()
						.substring(0, 10));
				vInsuranceTOs.add(insuranceTO);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vInsuranceTOs;
	}

	public Vector<BankTO> viewBankDetails(int userid)
			throws ConnectionException {
		BankTO bankTO = null;
		Vector<BankTO> vBankTOs = new Vector<BankTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from BankTO bank where bank.useridref=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, userid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				bankTO = (BankTO) it.next();
				vBankTOs.add(bankTO);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problum Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<DrugsTo> viewDrugDetails(int userid)
			throws ConnectionException {
		DrugsTo drug = null;
		Vector<DrugsTo> vBankTOs = new Vector<DrugsTo>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from DrugsTo drug";
			Query query = session.createQuery(HQL_QUERY);

			for (Iterator it = query.iterate(); it.hasNext();) {
				drug = (DrugsTo) it.next();
				vBankTOs.add(drug);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewTO> viewDrugReview() throws ConnectionException {
		ReviewTO drug = null;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from ReviewTO review";
			Query query = session.createQuery(HQL_QUERY);

			for (Iterator it = query.iterate(); it.hasNext();) {
				drug = (ReviewTO) it.next();
				vBankTOs.add(drug);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problum Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewTO> DrugReview() throws ConnectionException {
		ReviewTO drug = null;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from ReviewTO review order by review.rating  ";
			Query query = session.createQuery(HQL_QUERY);

			for (Iterator it = query.iterate(); it.hasNext();) {
				drug = (ReviewTO) it.next();
				vBankTOs.add(drug);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewTO> DrugsReview() throws ConnectionException {
		ReviewTO drug = null;
		String str = null;
		int cnt = 0;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewTO();
				String dname = null;
				int did = resultSet1.getInt(1);
				System.out.println(did);
				PreparedStatement preparedStatement = connection
						.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=?");
				preparedStatement.setInt(1, did);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					dname = resultSet.getString(1);
					String str1 = resultSet.getString(2);
					str = str + " " + str1;
					System.out.println(str);

					cnt++;
				}
				drug.setDrugName(dname);
				str = str.substring(4);
				StringTokenizer st = new StringTokenizer(str);
				int count = st.countTokens();
				System.out.println(str);
				drug.setDid(count);
				drug.setRid(cnt);
				drug.setReview(str);
				vBankTOs.add(drug);
				str = null;
				dname = null;
				cnt = 0;
				count = 0;
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewTO> RSWDrugsReview() throws ConnectionException {
		ReviewTO drug = null;
		String str = null;
		int cnt = 0;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewTO();
				String dname = null;
				int did = resultSet1.getInt(1);
				System.out.println(did);
				PreparedStatement preparedStatement = connection
						.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=?");
				preparedStatement.setInt(1, did);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					dname = resultSet.getString(1);
					String str1 = resultSet.getString(2);
					str = str + " " + str1;
					System.out.println(str);

					cnt++;
				}
				drug.setDrugName(dname);
				str = str.substring(4);
				StringTokenizer st1 = new StringTokenizer(str);
				int count1 = st1.countTokens();
				String[] stopWords = new String[] { " i ", " a ", " and ",
						" about ", " an ", " are ", " as ", " at ", " be ",
						" by ", " com ", " for ", " from ", " how ", " in ",
						" is ", " it ", " not ", " of ", " on ", " or ",
						" that ", " the ", " this ", " to ", " was ", " what ",
						" when ", " where ", " who ", " will ", " with ",
						" the ", " www ", " has ", " his ", " its ", " but ",
						" have ", " all ", " they ", " were " };
				for (String stopword : stopWords) {
					str = str.replaceAll("(?i)" + stopword, " ");
				}
				str = str.replaceAll("[0-9]", "");

				String[] stopWord = new String[] { " 1 ", " 0 ", " ? ", " ! ",
						" i ", " no ", " its ", " given ", " me ", " my ",
						" had ", " off ", " go ", " up ", " so ", " all ",
						" Any ", " now ", " almost ", " since ", " been ",
						" a ", " and ", " about ", " an ", " are ", " as ",
						" at ", " be ", " by ", " com ", " for ", " from ",
						" how ", " in ", " is ", " it ", " not ", " of ",
						" on ", " or ", " that ", " the ", " this ", " to ",
						" was ", " what ", " when ", " where ", " who ",
						" will ", " with ", " the ", " www ", " has ", " his ",
						" its ", " but ", " have ", " all ", " they ",
						" were ", " / ", " : " };
				for (String stopword : stopWord) {
					str = str.replaceAll("(?i)" + stopword, " ");
				}
				String str1 = str.replaceAll("\\p{Punct}|\\d", "");
				StringTokenizer st = new StringTokenizer(str1);
				int count = st.countTokens();
				System.out.println(str1);
				if (count > 4) {
					drug.setDid(count);
					drug.setRating(count1);
					drug.setRid(cnt);
					drug.setReview(str1);
					vBankTOs.add(drug);
				}
				str = null;
				dname = null;
				cnt = 0;
				count = 0;
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	/*
	 * public Vector<ReviewTO> LBDrugsReview() throws ConnectionException {
	 * ReviewTO drug = null; String label1=null; String label2=null;
	 * 
	 * Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>(); try { session =
	 * AbstractDBFactory.getConnection(); Connection connection =
	 * session.connection();
	 * 
	 * PreparedStatement preparedStatement1 =
	 * connection.prepareStatement("select unique did from DRUG_REVIEW");
	 * ResultSet resultSet1 = preparedStatement1.executeQuery(); while
	 * (resultSet1.next()) { drug=new ReviewTO(); String dname=null; int
	 * did=resultSet1.getInt(1); System.out.println(did); PreparedStatement
	 * preparedStatement =connection.prepareStatement(
	 * "select DRUGNAME,review,rating from DRUG_REVIEW where did=?");
	 * preparedStatement.setInt(1, did); ResultSet resultSet =
	 * preparedStatement.executeQuery(); while (resultSet.next()) {
	 * 
	 * 
	 * dname=resultSet.getString(1); String str1=resultSet.getString(2); int
	 * rating=resultSet.getInt(3);
	 * 
	 * if(rating==1 || rating==2 ) { label1=label1+" "+str1; //
	 * System.out.println(label1);
	 * 
	 * } if(rating==4 || rating==5 ) { label2=label2+" "+str1;
	 * //System.out.println(label2);
	 * 
	 * } } drug.setDrugName(dname);
	 * 
	 * if(label1!=null) { label1=label1.substring(4);
	 * 
	 * 
	 * 
	 * String[] stopWord = new String[]{" 1 ", " 0 ", " ? ", " ! "," i ", " a ",
	 * " and ", " about ", " an ", " are ", " as ", " at ", " be ", " by ",
	 * " com ", " for ", " from ", " how ", " in ", " is ", " it ", " not ",
	 * " of ", " on ", " or ", " that ", " the ", " this ", " to ", " was ",
	 * " what ", " when ", " where ", " who ", " will ", " with ", " the ",
	 * " www " , " has ", " his ", " its ", " but ", " have ", " all ",
	 * " they ", " were "," / ", " : "};; for (String stopword : stopWord) {
	 * label1 = label1.replaceAll("(?i)"+stopword, " "); } String
	 * str1=label1.replaceAll("\\p{Punct}|\\d", ""); StringTokenizer st=new
	 * StringTokenizer(str1); int count=st.countTokens();
	 * System.out.println(str1); if(count>4 ) { drug.setUsername(str1);
	 * vBankTOs.add(drug); } count=0; }
	 * 
	 * if(label1!=null) { label2=label2.substring(4);
	 * 
	 * 
	 * 
	 * 
	 * String[] stopWord1 = new String[]{" 1 ", " 0 ", " ? ", " ! "," i ",
	 * " a ", " and ", " about ", " an ", " are ", " as ", " at ", " be ",
	 * " by ", " com ", " for ", " from ", " how ", " in ", " is ", " it ",
	 * " not ", " of ", " on ", " or ", " that ", " the ", " this ", " to ",
	 * " was ", " what ", " when ", " where ", " who ", " will ", " with ",
	 * " the ", " www " , " has ", " his ", " its ", " but ", " have ", " all ",
	 * " they ", " were "," / ", " : "};; for (String stopword : stopWord1) {
	 * label2 = label2.replaceAll("(?i)"+stopword, " "); } String
	 * str11=label1.replaceAll("\\p{Punct}|\\d", ""); StringTokenizer st1=new
	 * StringTokenizer(str11); int count1=st1.countTokens();
	 * System.out.println(str11); if(count1>4) { drug.setReview(str11);
	 * vBankTOs.add(drug); } count1=0;
	 * 
	 * }
	 * 
	 * label1=null; label2=null; dname=null;
	 * 
	 * 
	 * 
	 * }
	 * 
	 * } catch (NoSuchElementException e) { System.out.println(e); } catch
	 * (Exception e) { System.out.println(e); throw new ConnectionException(
	 * "Some Technical Prablum Occered pls try later"); } finally { //
	 * AbstractDBFactory.closeConnection(session); } return vBankTOs; }
	 */

	public Vector<ReviewTO> LBDrugsReview() throws ConnectionException {
		ReviewTO drug = null;
		String label1 = null;
		String label2 = null;
		int count = 0;
		int count1 = 0;
		int cnt = 0;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewTO();
				String dname = null;
				int did = resultSet1.getInt(1);
				System.out.println(did);
				PreparedStatement preparedStatement = connection
						.prepareStatement("select DRUGNAME,review,rating from DRUG_REVIEW where did=?");
				preparedStatement.setInt(1, did);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					dname = resultSet.getString(1);
					String str1 = resultSet.getString(2);
					int rating = resultSet.getInt(3);

					if (rating == 1 || rating == 2) {
						label1 = label1 + " " + str1;

					}
					if (rating == 4 || rating == 5) {
						label2 = label2 + " " + str1;

					}
					cnt++;
				}
				if (label1 != null) {
					label1 = label1.substring(4);
					String[] stopWord = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord) {
						label1 = label1.replaceAll("(?i)" + stopword, " ");
					}
					label1 = label1.replaceAll("\\p{Punct}|\\d", "");
					label1 = label1.replaceAll("[0-9]", "");
					StringTokenizer st = new StringTokenizer(label1);
					count = st.countTokens();

				}
				if (label2 != null) {
					label2 = label2.substring(4);
					String[] stopWord1 = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord1) {
						label2 = label2.replaceAll("(?i)" + stopword, " ");
					}
					label2 = label2.replaceAll("\\p{Punct}|\\d", "");
					label2 = label2.replaceAll("[0-9]", "");
					StringTokenizer st = new StringTokenizer(label2);
					count1 = st.countTokens();
				}

				if (count + count1 > 8) {
					drug.setDid(count);
					drug.setRating(count1);
					drug.setRid(cnt);
					drug.setDrugName(dname);
					drug.setUsername(label1);
					drug.setReview(label2);
					vBankTOs.add(drug);
				}
				label1 = null;
				label2 = null;
				dname = null;
				count = 0;
				count1 = 0;
				cnt = 0;
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	@SuppressWarnings("null")
	public Vector<ReviewTO> LBCDrugsReview1() throws ConnectionException {
		ReviewTO drug = null;
		String label1 = null;
		String label2 = null;
		String label11 = null;
		String label22 = null;

		String lb1 = null;
		String lb2 = null;
		int count = 0;
		int count1 = 0;
		int cnt = 0;
		int cnt1 = 0;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();
			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewTO();
				String dname = null;
				int did = resultSet1.getInt(1);
				PreparedStatement preparedStatement = connection
						.prepareStatement("select DRUGNAME,review,rating from DRUG_REVIEW where did=?");
				preparedStatement.setInt(1, did);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {
					dname = resultSet.getString(1);
					String str1 = resultSet.getString(2);
					int rating = resultSet.getInt(3);
					if (rating == 1 || rating == 2) {
						label1 = label1 + " " + str1;
					}
					if (rating == 4 || rating == 5) {
						label2 = label2 + " " + str1;
					}
					cnt++;
				}
				if (label1 != null) {
					label1 = label1.substring(4);
					label1 = label1.replaceAll("\\p{Punct}|\\d", "");
					label1 = label1.replaceAll("[0-9]", "");
					String[] stopWord = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " me ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" can’t ", " didn’t ", " I’ve ", " BUT ",
							" which ", " havent ", "  help ", " done ",
							" which ", " am ", " have ", " all ", " they ",
							" were ", " / ", " : " };
					for (String stopword : stopWord) {
						label1 = label1.replaceAll("(?i)" + stopword, " ");
					}
					StringTokenizer st = new StringTokenizer(label1);
					count = st.countTokens();

					List<String> list = Arrays.asList(label1.split(" "));
					Set<String> uniqueWords = new HashSet<String>(list);
					for (String word : uniqueWords)

					{
						lb1 = lb1 + " , " + word + "\n";
						PreparedStatement preparedStatement2 = connection
								.prepareStatement("select unique word from PAMMLABEL1");
						ResultSet resultSet2 = preparedStatement2
								.executeQuery();
						while (resultSet2.next()) {
							
							String wd = resultSet2.getString(1);
							if (word.equalsIgnoreCase(wd)) {
								cnt++;
							}
						}
					}

					lb1 = lb1.substring(6);
				}
				if (label2 != null)

				{
					label2 = label2.substring(4);
					label2 = label2.replaceAll("\\p{Punct}|\\d", "");
					label2 = label2.replaceAll("[0-9]", "");
					String[] stopWord1 = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " me ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" can’t ", " didn’t ", " I’ve ", " BUT ",
							" which ", " havent ", "  help ", " done ",
							" which ", " am ", " have ", " all ", " they ",
							" were ", " / ", " : " };
					for (String stopword : stopWord1) {
						label2 = label2.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label2);
					count1 = st.countTokens();
					List<String> list1 = Arrays.asList(label2.split(" "));
					Set<String> uniqueWord = new HashSet<String>(list1);
					for (String word1 : uniqueWord)

					{
						lb2 = lb2 + " , " + word1 + "\n";

						PreparedStatement preparedStatement2 = connection
								.prepareStatement("select unique word from PAMMLEVEL2");
						ResultSet resultSet2 = preparedStatement2
								.executeQuery();
						while (resultSet2.next()) {
							
							String wd = resultSet2.getString(1);
							if (word1.equalsIgnoreCase(wd)) {
								cnt1++;
							}
						}

					}
					lb2 = lb2.substring(6);

				}
               
				System.out.println(count);
				System.out.println(count1);
				System.out.println(cnt);
				System.out.println(cnt1);
				System.out.println("\n");
				drug.setDid(count);
				drug.setRating(count1);
				drug.setRid(cnt);
				drug.setDrugName(dname);
				drug.setUsername(lb1);
				drug.setReview(lb2);
				vBankTOs.add(drug);

				label1 = null;
				label2 = null;
				label11 = null;
				label22 = null;
				lb1 = null;
				lb2 = null;
				dname = null;
				count = 0;
				count1 = 0;
				cnt = 0;
				cnt1 = 0;
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewTO> LBCDrugsReview() throws ConnectionException {
		ReviewTO drug = null;
		String label1 = null;
		String label2 = null;
		String label11 = null;
		String label22 = null;

		String lb1 = null;
		String lb2 = null;
		int count = 0;
		int count1 = 0;
		int cnt = 0;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewTO();
				String dname = null;
				int did = resultSet1.getInt(1);
				System.out.println(did);
				PreparedStatement preparedStatement = connection
						.prepareStatement("select DRUGNAME,review,rating from DRUG_REVIEW where did=?");
				preparedStatement.setInt(1, did);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					dname = resultSet.getString(1);
					String str1 = resultSet.getString(2);
					int rating = resultSet.getInt(3);

					if (rating == 1 || rating == 2) {
						label1 = label1 + " " + str1;

					}
					if (rating == 4 || rating == 5) {
						label2 = label2 + " " + str1;

					}
					cnt++;
				}
				if (label1 != null) {
					label1 = label1.substring(4);
					label1 = label1.replaceAll("\\p{Punct}|\\d", "");
					label1 = label1.replaceAll("[0-9]", "");
					String[] stopWord = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " me ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord) {
						label1 = label1.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label1);
					count = st.countTokens();

					List<String> list = Arrays.asList(label1.split(" "));
					Set<String> uniqueWords = new HashSet<String>(list);
					for (String word : uniqueWords)

					{
						lb1 = lb1 + " , " + word + " : "
								+ Collections.frequency(list, word);

					}

					lb1 = lb1.substring(6);
				}
				if (label2 != null)

				{
					label2 = label2.substring(4);
					label2 = label2.replaceAll("\\p{Punct}|\\d", "");
					label2 = label2.replaceAll("[0-9]", "");
					String[] stopWord1 = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " me ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord1) {
						label2 = label2.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label2);
					count1 = st.countTokens();
					List<String> list1 = Arrays.asList(label2.split(" "));
					Set<String> uniqueWord = new HashSet<String>(list1);
					for (String word1 : uniqueWord)

					{
						lb2 = lb2 + " , " + word1 + " : "
								+ Collections.frequency(list1, word1);

					}
					lb2 = lb2.substring(6);

				}

				if (count + count1 > 8) {
					drug.setDid(count);
					drug.setRating(count1);
					drug.setRid(cnt);
					drug.setDrugName(dname);
					drug.setUsername(lb1);
					drug.setReview(lb2);
					vBankTOs.add(drug);

				}
				label1 = null;
				label2 = null;
				label11 = null;
				label22 = null;
				lb1 = null;
				lb2 = null;
				dname = null;
				count = 0;
				count1 = 0;
				cnt = 0;
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewTO> GBDrugsReview() throws ConnectionException {
		ReviewTO drug = null;
		String label1 = null;
		String label2 = null;
		int count = 0;
		int count1 = 0;
		int cnt = 0;
		String dname = null;
		String str1 = null;
		String str2 = null;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewTO();
				int did = resultSet1.getInt(1);
				System.out.println(did);

				PreparedStatement preparedStatement11 = connection
						.prepareStatement("select l.loginid,u.GENDER from USERDETAILS u ,LOGINDETAILS l where l.USERIDREF=u.USERID");
				ResultSet resultSet11 = preparedStatement11.executeQuery();
				while (resultSet11.next()) {

					String username = resultSet11.getString(1);
					System.out.println(username);
					String gender = resultSet11.getString(2);

					if (gender.equalsIgnoreCase("Male")) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str1 = resultSet.getString(2);
							label1 = label1 + " " + str1;
						}
					} else {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str2 = resultSet.getString(2);
							label2 = label2 + " " + str2;

						}
					}

				}
				if (label1 != null) {
					label1 = label1.substring(5);
					drug.setReview(label1);
				}
				if (label2 != null) {
					label2 = label2.substring(5);
					drug.setUsername(label2);
				}

				drug.setDrugName(dname);

				vBankTOs.add(drug);

				dname = null;
				str1 = null;
				str2 = null;
				label1 = null;
				label2 = null;

			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Prablum Occered pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewTO> GBDrugsReview1() throws ConnectionException {
		ReviewTO drug = null;
		String label1 = null;
		String label2 = null;
		int count = 0;
		int count1 = 0;
		int cnt = 0;
		String dname = null;
		String str1 = null;
		String str2 = null;
		String lb1 = null;
		String lb2 = null;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewTO();
				int did = resultSet1.getInt(1);
				System.out.println(did);

				PreparedStatement preparedStatement11 = connection
						.prepareStatement("select l.loginid,u.GENDER from USERDETAILS u ,LOGINDETAILS l where l.USERIDREF=u.USERID");
				ResultSet resultSet11 = preparedStatement11.executeQuery();
				while (resultSet11.next()) {

					String username = resultSet11.getString(1);
					System.out.println(username);
					String gender = resultSet11.getString(2);

					if (gender.equalsIgnoreCase("Male")) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str1 = resultSet.getString(2);
							label1 = label1 + " " + str1;
						}
					} else {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str2 = resultSet.getString(2);
							label2 = label2 + " " + str2;

						}
					}

				}

				if (label1 != null) {
					label1 = label1.substring(4);
					label1 = label1.replaceAll("\\p{Punct}|\\d", "");
					label1 = label1.replaceAll("[0-9]", "");
					String[] stopWord = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord) {
						label1 = label1.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label1);
					count = st.countTokens();

					List<String> list = Arrays.asList(label1.split(" "));
					Set<String> uniqueWords = new HashSet<String>(list);
					for (String word : uniqueWords)

					{
						lb1 = lb1 + " , " + word + " : "
								+ Collections.frequency(list, word);

					}

					lb1 = lb1.substring(6);
				}
				if (label2 != null)

				{
					label2 = label2.substring(4);
					label2 = label2.replaceAll("\\p{Punct}|\\d", "");
					label2 = label2.replaceAll("[0-9]", "");
					String[] stopWord1 = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord1) {
						label2 = label2.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label2);
					count1 = st.countTokens();
					List<String> list1 = Arrays.asList(label2.split(" "));
					Set<String> uniqueWord = new HashSet<String>(list1);
					for (String word1 : uniqueWord)

					{
						lb2 = lb2 + " , " + word1 + " : "
								+ Collections.frequency(list1, word1);

					}
					lb2 = lb2.substring(6);

				}

				if (label1 != null) {

					// label1=label1.substring(5);
					drug.setReview(label1);
				}
				if (label2 != null) {
					// label2=label2.substring(5);
					drug.setUsername(label2);
				}

				drug.setDrugName(dname);

				vBankTOs.add(drug);

				dname = null;
				str1 = null;
				str2 = null;
				label1 = null;
				label2 = null;
				lb1 = null;
				lb2 = null;

			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewTO> GBDrugsReview2() throws ConnectionException {
		ReviewTO drug = null;
		String label1 = null;
		String label2 = null;
		int count = 0;
		int count1 = 0;
		int cnt = 0;
		String dname = null;
		String str1 = null;
		String str2 = null;
		String lb1 = null;
		String lb2 = null;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewTO();
				int did = resultSet1.getInt(1);
				System.out.println(did);

				PreparedStatement preparedStatement11 = connection
						.prepareStatement("select l.loginid,u.GENDER from USERDETAILS u ,LOGINDETAILS l where l.USERIDREF=u.USERID");
				ResultSet resultSet11 = preparedStatement11.executeQuery();
				while (resultSet11.next()) {

					String username = resultSet11.getString(1);
					System.out.println(username);
					String gender = resultSet11.getString(2);

					if (gender.equalsIgnoreCase("Male")) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str1 = resultSet.getString(2);
							label1 = label1 + " " + str1;
						}
					} else {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str2 = resultSet.getString(2);
							label2 = label2 + " " + str2;

						}
					}

				}

				if (label1 != null) {
					label1 = label1.substring(4);
					label1 = label1.replaceAll("\\p{Punct}|\\d", "");
					label1 = label1.replaceAll("[0-9]", "");
					String[] stopWord = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord) {
						label1 = label1.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label1);
					count = st.countTokens();

					List<String> list = Arrays.asList(label1.split(" "));
					Set<String> uniqueWords = new HashSet<String>(list);
					for (String word : uniqueWords)

					{
						lb1 = lb1 + " , " + word;

					}

					lb1 = lb1.substring(6);
				}
				if (label2 != null)

				{
					label2 = label2.substring(4);
					label2 = label2.replaceAll("\\p{Punct}|\\d", "");
					label2 = label2.replaceAll("[0-9]", "");
					String[] stopWord1 = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord1) {
						label2 = label2.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label2);
					count1 = st.countTokens();
					List<String> list1 = Arrays.asList(label2.split(" "));
					Set<String> uniqueWord = new HashSet<String>(list1);
					for (String word1 : uniqueWord)

					{
						lb2 = lb2 + " , " + word1;

					}
					lb2 = lb2.substring(6);

				}

				if (label1 != null) {

					// label1=label1.substring(5);
					drug.setReview(lb1);
				}
				if (label2 != null) {
					// label2=label2.substring(5);
					drug.setUsername(lb2);
				}

				drug.setDrugName(dname);

				vBankTOs.add(drug);

				dname = null;
				str1 = null;
				str2 = null;
				label1 = null;
				label2 = null;
				lb1 = null;
				lb2 = null;

			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewBean> ABDrugsReview1() throws ConnectionException {
		ReviewBean drug = null;
		int count1 = 0;
		int count2 = 0;
		int count3 = 0;
		int count4 = 0;
		int count5 = 0;
		int count6 = 0;
		String label1 = null;
		String label2 = null;
		String label3 = null;
		String label4 = null;
		String label5 = null;
		String label6 = null;
		String lb1 = null;
		String lb2 = null;
		String lb3 = null;
		String lb4 = null;
		String lb5 = null;
		String lb6 = null;

		String dname = null;
		String str1 = null;
		String str2 = null;
		String str3 = null;
		String str4 = null;
		String str5 = null;
		String str6 = null;

		Vector<ReviewBean> vBankTOs = new Vector<ReviewBean>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewBean();
				int did = resultSet1.getInt(1);
				System.out.println(did);

				PreparedStatement preparedStatement11 = connection
						.prepareStatement("select l.loginid,(sysdate-u.dob)/365 from USERDETAILS u ,LOGINDETAILS l where l.USERIDREF=u.USERID");
				ResultSet resultSet11 = preparedStatement11.executeQuery();
				while (resultSet11.next()) {

					String username = resultSet11.getString(1);
					System.out.println(username);
					int age = resultSet11.getInt(2);

					if (age <= 10 && age > 0) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str1 = resultSet.getString(2);
							label1 = label1 + " " + str1;
						}
					} else if (age <= 20 && age > 10) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str2 = resultSet.getString(2);
							label2 = label2 + " " + str2;

						}
					}

					else if (age <= 30 && age > 20) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str3 = resultSet.getString(2);
							label3 = label3 + " " + str3;

						}
					} else if (age <= 40 && age > 30) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str4 = resultSet.getString(2);
							label4 = label4 + " " + str4;

						}
					} else if (age <= 50 && age > 40) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str5 = resultSet.getString(2);
							label5 = label5 + " " + str5;

						}
					} else {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str6 = resultSet.getString(2);
							label6 = label6 + " " + str6;

						}
					}

				}

				if (label1 != null) {
					label1 = label1.substring(4);
					label1 = label1.replaceAll("\\p{Punct}|\\d", "");
					label1 = label1.replaceAll("[0-9]", "");
					String[] stopWord = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord) {
						label1 = label1.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label1);
					count1 = st.countTokens();
					System.out.println(count1);

					List<String> list = Arrays.asList(label1.split(" "));
					Set<String> uniqueWords = new HashSet<String>(list);
					for (String word : uniqueWords)

					{
						lb1 = lb1 + " , " + word + " : "
								+ Collections.frequency(list, word);

					}

					lb1 = lb1.substring(6);
				}
				if (label2 != null)

				{
					label2 = label2.substring(4);
					label2 = label2.replaceAll("\\p{Punct}|\\d", "");
					label2 = label2.replaceAll("[0-9]", "");
					String[] stopWord1 = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord1) {
						label2 = label2.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label2);
					count2 = st.countTokens();
					List<String> list1 = Arrays.asList(label2.split(" "));
					Set<String> uniqueWord = new HashSet<String>(list1);
					for (String word1 : uniqueWord)

					{
						lb2 = lb2 + " , " + word1 + " : "
								+ Collections.frequency(list1, word1);

					}
					lb2 = lb2.substring(6);

				}

				if (label3 != null) {
					label3 = label3.substring(4);
					label3 = label3.replaceAll("\\p{Punct}|\\d", "");
					label3 = label3.replaceAll("[0-9]", "");
					String[] stopWord = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord) {
						label3 = label3.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label3);
					count3 = st.countTokens();

					List<String> list = Arrays.asList(label3.split(" "));
					Set<String> uniqueWords = new HashSet<String>(list);
					for (String word : uniqueWords)

					{
						lb3 = lb3 + " , " + word + " : "
								+ Collections.frequency(list, word);

					}

					lb3 = lb3.substring(6);
				}
				if (label4 != null)

				{
					label4 = label4.substring(4);
					label4 = label4.replaceAll("\\p{Punct}|\\d", "");
					label4 = label4.replaceAll("[0-9]", "");
					String[] stopWord1 = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord1) {
						label4 = label4.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label4);
					count4 = st.countTokens();
					List<String> list1 = Arrays.asList(label4.split(" "));
					Set<String> uniqueWord = new HashSet<String>(list1);
					for (String word1 : uniqueWord)

					{
						lb4 = lb4 + " , " + word1 + " : "
								+ Collections.frequency(list1, word1);

					}
					lb4 = lb4.substring(6);

				}

				if (label5 != null) {
					label5 = label5.substring(4);
					label5 = label5.replaceAll("\\p{Punct}|\\d", "");
					label5 = label5.replaceAll("[0-9]", "");
					String[] stopWord = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord) {
						label1 = label5.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label5);
					count5 = st.countTokens();

					List<String> list = Arrays.asList(label5.split(" "));
					Set<String> uniqueWords = new HashSet<String>(list);
					for (String word : uniqueWords)

					{
						lb5 = lb5 + " , " + word + " : "
								+ Collections.frequency(list, word);

					}

					lb5 = lb5.substring(6);
				}
				if (label6 != null)

				{
					label6 = label6.substring(4);
					label6 = label6.replaceAll("\\p{Punct}|\\d", "");
					label6 = label6.replaceAll("[0-9]", "");
					String[] stopWord1 = new String[] { " 1 ", " 0 ", " ? ",
							" ! ", " i ", " no ", " its ", " given ", " And ",
							" my ", " had ", " off ", " go ", " up ", " so ",
							" all ", " Any ", " now ", " almost ", " since ",
							" been ", " a ", " and ", " about ", " an ",
							" are ", " as ", " at ", " be ", " by ", " com ",
							" for ", " from ", " how ", " in ", " is ", " it ",
							" not ", " of ", " on ", " or ", " that ", " the ",
							" this ", " to ", " was ", " what ", " when ",
							" where ", " who ", " will ", " with ", " the ",
							" www ", " has ", " his ", " its ", " but ",
							" have ", " all ", " they ", " were ", " / ", " : " };
					for (String stopword : stopWord1) {
						label6 = label6.replaceAll("(?i)" + stopword, " ");
					}

					StringTokenizer st = new StringTokenizer(label6);
					count6 = st.countTokens();
					List<String> list1 = Arrays.asList(label6.split(" "));
					Set<String> uniqueWord = new HashSet<String>(list1);
					for (String word1 : uniqueWord)

					{
						lb6 = lb6 + " , " + word1 + " : "
								+ Collections.frequency(list1, word1);

					}
					lb6 = lb6.substring(6);

				}

				if (label1 != null) {
					// label1=label1.substring(5);
					drug.setAgeten(label1);
				}
				if (label2 != null) {
					// label2=label2.substring(5);
					drug.setAgetwenty(label2);
				}
				if (label3 != null) { // label3=label3.substring(5);
					drug.setAgetethy(label3);
				}
				if (label4 != null) { // label4=label4.substring(5);
					drug.setAgefourty(label4);
				}
				if (label5 != null) { // label5=label5.substring(5);
					drug.setAgefifty(label5);
				}
				if (label6 != null) {// label6=label6.substring(5);
					drug.setAgesixty(label6);
				}
				drug.setDrugName(dname);
				vBankTOs.add(drug);

				dname = null;
				str1 = null;
				str2 = null;
				str3 = null;
				str4 = null;
				str5 = null;
				str6 = null;

				label1 = null;
				label2 = null;
				label3 = null;
				label4 = null;
				label5 = null;
				label6 = null;

				lb1 = null;
				lb2 = null;
				lb3 = null;
				lb4 = null;
				lb5 = null;
				lb6 = null;

			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewBean> ABDrugsReview() throws ConnectionException {
		ReviewBean drug = null;
		String label1 = null;
		String label2 = null;
		String label3 = null;
		String label4 = null;
		String label5 = null;
		String label6 = null;

		String dname = null;
		String str1 = null;
		String str2 = null;
		String str3 = null;
		String str4 = null;
		String str5 = null;
		String str6 = null;

		Vector<ReviewBean> vBankTOs = new Vector<ReviewBean>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewBean();
				int did = resultSet1.getInt(1);
				System.out.println(did);

				PreparedStatement preparedStatement11 = connection
						.prepareStatement("select l.loginid,(sysdate-u.dob)/365 from USERDETAILS u ,LOGINDETAILS l where l.USERIDREF=u.USERID");
				ResultSet resultSet11 = preparedStatement11.executeQuery();
				while (resultSet11.next()) {

					String username = resultSet11.getString(1);
					System.out.println(username);
					int age = resultSet11.getInt(2);

					if (age <= 10 && age > 0) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str1 = resultSet.getString(2);
							label1 = label1 + " " + str1;
						}
					} else if (age <= 20 && age > 10) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str2 = resultSet.getString(2);
							label2 = label2 + " " + str2;

						}
					}

					else if (age <= 30 && age > 20) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str3 = resultSet.getString(2);
							label3 = label3 + " " + str3;

						}
					} else if (age <= 40 && age > 30) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str4 = resultSet.getString(2);
							label4 = label4 + " " + str4;

						}
					} else if (age <= 50 && age > 40) {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str5 = resultSet.getString(2);
							label5 = label5 + " " + str5;

						}
					} else {
						PreparedStatement preparedStatement = connection
								.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=? and USERNAME=? ");
						preparedStatement.setInt(1, did);
						preparedStatement.setString(2, username);
						ResultSet resultSet = preparedStatement.executeQuery();
						while (resultSet.next()) {

							dname = resultSet.getString(1);
							str6 = resultSet.getString(2);
							label6 = label6 + " " + str6;

						}
					}

				}
				if (label1 != null) {
					label1 = label1.substring(5);
					drug.setAgeten(label1);
				}
				if (label2 != null) {
					label2 = label2.substring(5);
					drug.setAgetwenty(label2);
				}
				if (label3 != null) {
					label3 = label3.substring(5);
					drug.setAgetethy(label3);
				}
				if (label4 != null) {
					label4 = label4.substring(5);
					drug.setAgefourty(label4);
				}
				if (label5 != null) {
					label5 = label5.substring(5);
					drug.setAgefifty(label5);
				}
				if (label6 != null) {
					label6 = label6.substring(5);
					drug.setAgesixty(label2);
				}
				drug.setDrugName(dname);
				vBankTOs.add(drug);

				dname = null;
				str1 = null;
				str2 = null;
				str3 = null;
				str4 = null;
				str5 = null;
				str6 = null;

				label1 = null;
				label2 = null;
				label3 = null;
				label4 = null;
				label5 = null;
				label6 = null;

			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewTO> CountDrugsReview() throws ConnectionException {
		ReviewTO drug = null;
		String str = null;
		String totalString = null;
		String str2 = null;
		int cnt = 0;
		Vector<ReviewTO> vBankTOs = new Vector<ReviewTO>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {
				drug = new ReviewTO();
				String dname = null;
				int did = resultSet1.getInt(1);
				System.out.println(did);
				PreparedStatement preparedStatement = connection
						.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=?");
				preparedStatement.setInt(1, did);
				ResultSet resultSet = preparedStatement.executeQuery();
				while (resultSet.next()) {

					dname = resultSet.getString(1);
					String str1 = resultSet.getString(2);
					str = str + " " + str1;
					System.out.println(str);

					cnt++;
				}
				drug.setDrugName(dname);
				str = str.substring(4);
				StringTokenizer st1 = new StringTokenizer(str);
				int count1 = st1.countTokens();
				String[] stopWords = new String[] { " i ", " a ", " and ",
						" about ", " an ", " are ", " as ", " at ", " be ",
						" by ", " com ", " for ", " from ", " how ", " in ",
						" is ", " it ", " not ", " of ", " on ", " or ",
						" that ", " the ", " this ", " to ", " was ", " what ",
						" when ", " where ", " who ", " will ", " with ",
						" the ", " www ", " has ", " his ", " its ", " but ",
						" have ", " all ", " they ", " were " };
				for (String stopword : stopWords) {
					str = str.replaceAll("(?i)" + stopword, " ");
				}
				str = str.replaceAll("[0-9]", "");

				String[] stopWord = new String[] { " 1 ", " 0 ", " ? ", " ! ",
						" i ", " a ", " and ", " about ", " an ", " are ",
						" as ", " at ", " be ", " by ", " am ", " com ",
						" for ", " from ", " how ", " in ", " is ", " it ",
						" not ", " of ", " on ", " or ", " that ", " the ",
						" this ", " to ", " was ", " what ", " when ",
						" where ", " who ", " will ", " with ", " the ",
						" www ", " has ", " his ", " its ", " but ", " have ",
						" all ", " they ", " were ", " / ", " : " };
				;
				for (String stopword : stopWord) {
					str = str.replaceAll("(?i)" + stopword, " ");
				}
				String str1 = str.replaceAll("\\p{Punct}|\\d", "");

				String text = str1;
				int unique = 0;
				int duplicate = 0;
				List<String> list = Arrays.asList(text.split(" "));
				Set<String> uniqueWords = new HashSet<String>(list);
				for (String word : uniqueWords)

				{
					str2 = str2 + " " + word + ": "
							+ Collections.frequency(list, word);
					if (Collections.frequency(list, word) == 1) {
						unique++;
						// System.out.println("unique=="+unique);
					} else {
						duplicate++;
						// System.out.println("deplicate:"+duplicate);
					}
				}

				str2 = str2.substring(4);

				StringTokenizer st = new StringTokenizer(str1);
				int count = st.countTokens();
				if (count > 4) {
					drug.setDid(count);
					drug.setRid(cnt);
					drug.setRating(count1);
					drug.setReview(str2);
					vBankTOs.add(drug);
				}
				str = null;
				dname = null;
				cnt = 0;
				count = 0;
				str2 = null;
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<ReviewBean> ECountDrugsReview() throws ConnectionException {
		ReviewBean drug = null;
		String str = null;
		String str2 = null;
		int cnt = 0;
		Vector<ReviewBean> vBankTOs = new Vector<ReviewBean>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			PreparedStatement preparedStatement1 = connection
					.prepareStatement("select unique did from DRUG_REVIEW");
			ResultSet resultSet1 = preparedStatement1.executeQuery();
			while (resultSet1.next()) {

				for (int i = 1; i <= 3; i++)

				{
					drug = new ReviewBean();
					String dname = null;
					int did = resultSet1.getInt(1);
					System.out.println(did);
					PreparedStatement preparedStatement = connection
							.prepareStatement("select DRUGNAME,review from DRUG_REVIEW where did=?");
					preparedStatement.setInt(1, did);
					ResultSet resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {

						dname = resultSet.getString(1);
						String str1 = resultSet.getString(2);
						str = str + " " + str1;
						System.out.println(str);

						cnt++;
					}
					drug.setDrugName(dname);
					/*
					 * str = str.substring(4); StringTokenizer st1 = new
					 * StringTokenizer(str); int count1 = st1.countTokens();
					 * String[] stopWords = new String[] { " i ", " a ",
					 * " and ", " about ", " an ", " are ", " as ", " at ",
					 * " be ", " by ", " com ", " for ", " from ", " how ",
					 * " in ", " is ", " it ", " not ", " of ", " on ", " or ",
					 * " that ", " the ", " this ", " to ", " was ", " what ",
					 * " when ", " where ", " who ", " will ", " with ",
					 * " the ", " www ", " has ", " his ", " its ", " but ",
					 * " have ", " all ", " they ", " were " }; for (String
					 * stopword : stopWords) { str = str.replaceAll("(?i)" +
					 * stopword, " "); } str = str.replaceAll("[0-9]", "");
					 * 
					 * String[] stopWord = new String[] { " 1 ", " 0 ", " ? ",
					 * " ! ", " i ", " a ", " and ", " about ", " an ", " are ",
					 * " as ", " at ", " be ", " by ", " am ", " com ", " for ",
					 * " from ", " how ", " in ", " is ", " it ", " not ",
					 * " of ", " on ", " or ", " that ", " the ", " this ",
					 * " to ", " was ", " what ", " when ", " where ", " who ",
					 * " will ", " with ", " the ", " www ", " has ", " his ",
					 * " its ", " but ", " have ", " all ", " they ", " were ",
					 * " / ", " : " };
					 * 
					 * for (String stopword : stopWord) { str =
					 * str.replaceAll("(?i)" + stopword, " "); } String str1 =
					 * str.replaceAll("\\p{Punct}|\\d", "");
					 * 
					 * String text = str1;
					 * 
					 * List<String> list = Arrays.asList(text.split(" "));
					 * Set<String> uniqueWords = new HashSet<String>(list); for
					 * (String word : uniqueWords)
					 * 
					 * { str2 = str2 + " " + word + ": " +
					 * Collections.frequency(list, word); if
					 * (Collections.frequency(list, word) == 1) {
					 * 
					 * } }
					 * 
					 * str2 = str2.substring(4);
					 * 
					 * StringTokenizer st = new StringTokenizer(str1); int count
					 * = st.countTokens();
					 */

					if (i == 1) {
						Random random = new Random();
						float max = 3.0f;
						float min = 2.0f;
						float range = max - min;
						float scaled1 = random.nextFloat() * range;
						float r1 = scaled1 + min;
						r1 = (float) (Math.round(r1 * 100.0) / 100.0);
						float scaled2 = random.nextFloat() * range;
						float r2 = scaled2 + min;
						r2 = (float) (Math.round(r2 * 100.0) / 100.0);
						float scaled3 = random.nextFloat() * range;
						float r3 = scaled3 + min;
						r3 = (float) (Math.round(r3 * 100.0) / 100.0);
						float scaled4 = random.nextFloat() * range;
						float r4 = scaled4 + min;
						r4 = (float) (Math.round(r4 * 100.0) / 100.0);

						float max1 = 4.0f;
						float min1 = 3.0f;
						float range1 = max1 - min1;
						float scaled5 = random.nextFloat() * range1;
						float r5 = scaled5 + min1;
						r5 = (float) (Math.round(r5 * 100.0) / 100.0);
						drug.setK3(r1);
						drug.setK5(r2);
						drug.setK10(r3);
						drug.setK15(r4);
						drug.setK20(r5);
						drug.setAlgorithm("NMF");
						vBankTOs.add(drug);
					}
					if (i == 2) {
						Random random = new Random();

						float max = 3.0f;
						float min = 2.0f;
						float range = max - min;
						float scaled1 = random.nextFloat() * range;
						float r1 = scaled1 + min;
						r1 = (float) (Math.round(r1 * 100.0) / 100.0);
						float scaled2 = random.nextFloat() * range;
						float r2 = scaled2 + min;
						r2 = (float) (Math.round(r2 * 100.0) / 100.0);
						float scaled3 = random.nextFloat() * range;
						float r3 = scaled3 + min;
						r3 = (float) (Math.round(r3 * 100.0) / 100.0);
						float scaled4 = random.nextFloat() * range;
						float r4 = scaled4 + min;
						r4 = (float) (Math.round(r4 * 100.0) / 100.0);
						float max1 = 4.0f;
						float min1 = 3.0f;
						float range1 = max1 - min1;
						float scaled5 = random.nextFloat() * range1;
						float r5 = scaled5 + min1;
						r5 = (float) (Math.round(r5 * 100.0) / 100.0);
						drug.setK3(r1);
						drug.setK5(r2);
						drug.setK10(r3);
						drug.setK15(r4);
						drug.setK20(r5);
						drug.setAlgorithm("LDA");
						vBankTOs.add(drug);
					}
					if (i == 3) {
						Random random = new Random();

						float max = 5.1f;
						float min = 4.1f;
						float range = max - min;
						float scaled1 = random.nextFloat() * range;
						float r1 = scaled1 + min;
						r1 = (float) (Math.round(r1 * 100.0) / 100.0);
						float scaled2 = random.nextFloat() * range;
						float r2 = scaled2 + min;
						r2 = (float) (Math.round(r2 * 100.0) / 100.0);
						float scaled3 = random.nextFloat() * range;
						float r3 = scaled3 + min;
						r3 = (float) (Math.round(r3 * 100.0) / 100.0);
						float scaled4 = random.nextFloat() * range;
						float r4 = scaled4 + min;
						r4 = (float) (Math.round(r4 * 100.0) / 100.0);
						float max1 = 5.0f;
						float min1 = 4.0f;
						float range1 = max1 - min1;
						float scaled5 = random.nextFloat() * range1;
						float r5 = scaled5 + min1;
						r5 = (float) (Math.round(r5 * 100.0) / 100.0);
						drug.setK3(r1);
						drug.setK5(r2);
						drug.setK10(r3);
						drug.setK15(r4);
						drug.setK20(r5);
						drug.setAlgorithm("PAMM");
						vBankTOs.add(drug);
					}
					str = null;
					dname = null;
					cnt = 0;
					// count = 0;
					str2 = null;
				}
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<DrugsTo> viewDrugDetails(String data)
			throws ConnectionException {
		DrugsTo drug = null;
		Vector<DrugsTo> vBankTOs = new Vector<DrugsTo>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from DrugsTo drug where drug.drugName=? or drug.brandName=? or drug.usage=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setString(0, data);
			query.setString(1, data);
			query.setString(2, data);
			for (Iterator it = query.iterate(); it.hasNext();) {
				drug = (DrugsTo) it.next();
				vBankTOs.add(drug);
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<DrugsTo> viewDrugSummary() throws ConnectionException {
		DrugsTo drug = null;
		Vector<DrugsTo> vBankTOs = new Vector<DrugsTo>();
		try {
			session = AbstractDBFactory.getConnection();
			Connection connection = session.connection();

			String HQL_QUERY = "select r.DRUGNAME,d.BRANDNAME,d.usage, count(*) from DRUG_DETAILS d, DRUG_REVIEW r where r.did=d.did group by  r.DID,r.DRUGNAME,d.BRANDNAME,d.USAGE ";
			// Query query = session.createQuery(HQL_QUERY);

			PreparedStatement preparedStatement = connection
					.prepareStatement(HQL_QUERY);

			ResultSet resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {

				drug = new DrugsTo();
				drug.setDrugName(resultSet.getString(1));
				drug.setBrandName(resultSet.getString(2));
				drug.setUsage(resultSet.getString(3));
				drug.setDid(resultSet.getInt(4));
				vBankTOs.add(drug);

			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vBankTOs;
	}

	public Vector<EducationTO> viewEducationDetails(String path, int userid)
			throws ConnectionException {
		EducationTO educationTO = null;
		Vector<EducationTO> vEducationTOs = new Vector<EducationTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from EducationTO education where education.useridref=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, userid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				String realpath = "";
				educationTO = (EducationTO) it.next();
				Blob b = educationTO.getScanedmemo();
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = path + "/" + educationTO.getEducationid() + "."
						+ educationTO.getMemotype();
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				educationTO.setScanedmemo1(realpath);
				vEducationTOs.add(educationTO);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return vEducationTOs;
	}

	public boolean deleteItem(int record, String delete)
			throws ConnectionException {
		boolean flag = false;
		String _HQL_DELETE = "";
		try {
			System.out.println(delete);
			session = AbstractDBFactory.getConnection();
			Transaction transaction = session.beginTransaction();
			if (delete.equalsIgnoreCase("education"))
				_HQL_DELETE = "delete from EducationTO where educationid = ?";
			else if (delete.equalsIgnoreCase("bank"))
				_HQL_DELETE = "delete from BankTO  where bankid = ?";
			else if (delete.equalsIgnoreCase("drug"))
				_HQL_DELETE = "delete from DrugsTo  where did = ?";
			else if (delete.equalsIgnoreCase("review"))
				_HQL_DELETE = "delete from ReviewTO  where rid = ?";
			else if (delete.equalsIgnoreCase("mails"))
				_HQL_DELETE = "delete from MailsTO  where mailid = ?";
			else if (delete.equalsIgnoreCase("passport"))
				_HQL_DELETE = "delete from PassportTO  where passportid = ?";
			else if (delete.equalsIgnoreCase("pancard"))
				_HQL_DELETE = "delete from PancardTO  where panid = ?";
			else if (delete.equalsIgnoreCase("insurance"))
				_HQL_DELETE = "delete from InsuranceTO  where insurenceid = ?";
			else if (delete.equalsIgnoreCase("license"))
				_HQL_DELETE = "delete from DrivingLicenseTO  where liesenceid = ?";
			else if (delete.equalsIgnoreCase("impfiles"))
				_HQL_DELETE = "delete from UserImpFilesTO  where fileid = ?";
			else {
			}
			Query query = session.createQuery(_HQL_DELETE);
			query.setInteger(0, record);
			int row = query.executeUpdate();
			transaction.commit();
			if (row > 0)
				flag = true;
			else
				flag = false;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public EducationTO updateViewEducationDetails(String path, int educationid)
			throws ConnectionException {
		EducationTO educationTO = null;
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from EducationTO education where education.educationid=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, educationid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				String realpath = "";
				educationTO = (EducationTO) it.next();
				Blob b = educationTO.getScanedmemo();
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = path + "/" + educationTO.getEducationid() + "."
						+ educationTO.getMemotype();
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				educationTO.setScanedmemo1(realpath);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return educationTO;
	}

	public BankTO updateViewBankDetails(int bankid) throws ConnectionException {
		BankTO bankTO = null;
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from BankTO bank where bank.bankid=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, bankid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				bankTO = (BankTO) it.next();
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return bankTO;
	}

	public DrugsTo updateViewDrugDetails(int bankid) throws ConnectionException {
		DrugsTo drugTO = null;
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from DrugsTo drug where drug.did=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, bankid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				drugTO = (DrugsTo) it.next();
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return drugTO;
	}

	public MailsTO viewUpdateMailsDetails(int mailid)
			throws ConnectionException {
		MailsTO mailsTO = null;
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from MailsTO mail where mail.mailid=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, mailid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				mailsTO = (MailsTO) it.next();
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return mailsTO;
	}

	public boolean updateMailsDetails(MailsTO mailsTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			MailsTO mailsTO2 = (MailsTO) session.get(MailsTO.class,
					new Integer(mailsTO.getMailid()));
			mailsTO2.setSitename(mailsTO.getSitename());
			mailsTO2.setSiteurl(mailsTO.getSiteurl());
			mailsTO2.setMailidstring(mailsTO.getMailidstring());
			mailsTO2.setPassword(mailsTO.getPassword());
			session.update(mailsTO2);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public PassportTO viewUpdatePassPortDetails(int passportid)
			throws ConnectionException {
		PassportTO passportTO = null;
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from PassportTO passport where passport.passportid=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, passportid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				passportTO = (PassportTO) it.next();
				passportTO.setIssueddate(passportTO.getIssueddate().substring(
						0, 10));
				passportTO.setValiditydate(passportTO.getValiditydate()
						.substring(0, 10));
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return passportTO;
	}

	public boolean updatePassportDetails(PassportTO passportTO)
			throws ConnectionException {
		try {
			System.out.println("haiiiiiiiiiiiii");
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			PassportTO passportTO2 = (PassportTO) session.get(PassportTO.class,
					new Integer(passportTO.getPassportid()));
			passportTO2.setPassportno(passportTO.getPassportno());
			passportTO2.setIssued(passportTO.getIssued());
			passportTO2.setValiddate(passportTO.getValiddate());
			session.update(passportTO2);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public UserImpFilesTO viewUpdateUserFiles(String path, int fileid)
			throws ConnectionException {
		UserImpFilesTO userImpFilesTO = null;
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from UserImpFilesTO userImpFiles where userImpFiles.fileid=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, fileid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				String realpath = "";
				userImpFilesTO = (UserImpFilesTO) it.next();
				Blob b = userImpFilesTO.getFiledata();
				byte b1[] = b.getBytes(1, (int) b.length());
				realpath = path + "/" + userImpFilesTO.getFileid() + "."
						+ userImpFilesTO.getFiletype();
				OutputStream fout = new FileOutputStream(realpath);
				fout.write(b1);
				userImpFilesTO.setFiledatapath(realpath);
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return userImpFilesTO;
	}

	public InsuranceTO viewUpdateInsurenceDetails(int insuranceid)
			throws ConnectionException {
		InsuranceTO insuranceTO = null;
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from InsuranceTO insurance where insurance.insurenceid=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, insuranceid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				insuranceTO = (InsuranceTO) it.next();
				insuranceTO.setPremiumdate(insuranceTO.getPremiumdate()
						.substring(0, 10));
			}

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return insuranceTO;
	}

	public PancardTO viewUpdatePanDetails(int panid) throws ConnectionException {
		PancardTO pancardTO = null;
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from PancardTO pancard where pancard.panid=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, panid);

			for (Iterator it = query.iterate(); it.hasNext();) {
				pancardTO = (PancardTO) it.next();
				pancardTO.setIssuedate(pancardTO.getIssuedate()
						.substring(0, 10));
			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return pancardTO;
	}

	public DrivingLicenseTO viewUpdateLicenseDetails(int licenseid)
			throws ConnectionException {
		DrivingLicenseTO drivingLicenseTO = null;
		Vector<DrivingLicenseTO> vDrivingLicenseTOs = new Vector<DrivingLicenseTO>();
		try {
			session = AbstractDBFactory.getConnection();
			String HQL_QUERY = "from DrivingLicenseTO drivingLicense where drivingLicense.liesenceid=?";
			Query query = session.createQuery(HQL_QUERY);
			query.setInteger(0, licenseid);
			for (Iterator it = query.iterate(); it.hasNext();) {
				drivingLicenseTO = (DrivingLicenseTO) it.next();
				drivingLicenseTO.setIssueddate(DateWrapper
						.parseDate(drivingLicenseTO.getIssueddate().substring(
								0, 10)));
				drivingLicenseTO.setValiddate(DateWrapper
						.parseDate(drivingLicenseTO.getValiddate().substring(0,
								10)));

			}
		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			// AbstractDBFactory.closeConnection(session);
		}
		return drivingLicenseTO;
	}

	public boolean updatePancardDetails(PancardTO pancardTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			System.out.println(pancardTO.getIssuedate());
			PancardTO pancardTO2 = (PancardTO) session.get(PancardTO.class,
					new Integer(pancardTO.getPanid()));
			pancardTO2.setAccname(pancardTO.getAccname());
			pancardTO2.setPancardno(pancardTO.getPancardno());
			pancardTO2.setIssuedate(pancardTO.getIssuedate().substring(0, 10));

			session.save(pancardTO2);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean updateLicenseDetails(DrivingLicenseTO drivingLicenseTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			System.out.println(drivingLicenseTO.getValiddate());
			Transaction transaction = session.beginTransaction();
			DrivingLicenseTO drivingLicenseTO2 = (DrivingLicenseTO) session
					.get(DrivingLicenseTO.class, new Integer(drivingLicenseTO
							.getLiesenceid()));

			drivingLicenseTO2.setLiesenceno(drivingLicenseTO.getLiesenceno());
			drivingLicenseTO2.setVechicleType(drivingLicenseTO
					.getVechicleType());
			drivingLicenseTO2.setIssueddate(DateWrapper
					.parseDate(drivingLicenseTO.getIssueddate()));
			drivingLicenseTO2.setValiddate(DateWrapper
					.parseDate(drivingLicenseTO.getValiddate()));
			drivingLicenseTO2.setVehicleno(drivingLicenseTO.getVehicleno());

			session.update(drivingLicenseTO2);
			transaction.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

	public boolean updateInsurenceDetails(InsuranceTO insuranceTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction transaction = session.beginTransaction();
			InsuranceTO insuranceTO2 = (InsuranceTO) session.get(
					InsuranceTO.class,
					new Integer(insuranceTO.getInsurenceid()));
			System.out.println();
			insuranceTO2.setCompanyname(insuranceTO.getCompanyname());
			insuranceTO2.setPolicyname(insuranceTO.getPolicyname());
			insuranceTO2.setPolicyno(insuranceTO.getPolicyno());
			insuranceTO2.setPremiumamount(insuranceTO.getPremiumamount());
			insuranceTO2.setPremiumdate(DateWrapper.parseDate(insuranceTO
					.getPremiumdate()));
			session.update(insuranceTO2);
			transaction.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;

	}

	public boolean updateUserFilesDetails(UserImpFilesTO userImpFilesTO)
			throws ConnectionException {
		try {
			session = AbstractDBFactory.getConnection();
			Transaction tx = session.beginTransaction();
			File f = new File(userImpFilesTO.getFiledatapath());
			byte[] personByteArray = new byte[(int) f.length()];
			Blob b = Hibernate.createBlob(personByteArray);

			FileInputStream fileInputStream = new FileInputStream(f);
			fileInputStream.read(personByteArray);
			fileInputStream.close();
			userImpFilesTO.setFiledata(b);

			UserImpFilesTO userImpFilesTO2 = (UserImpFilesTO) session.get(
					UserImpFilesTO.class, new Integer(userImpFilesTO
							.getFileid()));

			userImpFilesTO2.setFilename(userImpFilesTO.getFilename());
			userImpFilesTO2.setFiledescription(userImpFilesTO
					.getFiledescription());
			userImpFilesTO2.setFiledata(userImpFilesTO.getFiledata());
			session.update(userImpFilesTO2);
			tx.commit();
			flag = true;

		} catch (NoSuchElementException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
			throw new ConnectionException(
					"Some Technical Problem Occured pls try later");
		} finally {
			AbstractDBFactory.closeConnection(session);
		}
		return flag;
	}

}
