/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import dataaccess.TitleDAO;
import dataaccess.TitleDAOImpl;
import java.util.List;
import transferobjects.Title;

/**
 *
 * @author Owner
 */
public class TitlesLogic {

    private static final int TITLE_LENGTH = 50;
    private static final int TITLE_DATE = 10;

    private TitleDAO titleDAO = null;

    public TitlesLogic() {
        titleDAO = new TitleDAOImpl();
    }

    public List<Title> getAllTitles() {
        return titleDAO.getAllTitles();
    }

    /**
     * validates the title then call DAO method
     *
     * @param title
     */
    public void addTitle(Title title) {
        cleanTitle(title);
        validateTitle(title);
        titleDAO.addTitle(title);
    }

    public List<Title> getTitleByEmployeeNo(Integer empNo) {
        return titleDAO.getTitleByEmployeeNo(empNo);
    }

    private void cleanTitle(Title title) {
        if (title.getEmpNo() != null) {
            title.setEmpNo(title.getEmpNo().trim());
        }

        if (title.getTitle() != null) {
            title.setTitle(title.getTitle().trim());
        }

        if (title.getFromDate() != null) {
            title.setFromDate(title.getFromDate().trim());
        }

        if (title.getToDate() != null) {
            title.setToDate(title.getToDate().trim());
        }
    }

    /**
     * validates for proper input
     *
     * @param title
     */
    private void validateTitle(Title title) {
        //validateString(title.getEmpNo(), "Employee Number", TITLE_NO_MAX_LENGTH, false);
        validateString(title.getTitle(), "Title", TITLE_LENGTH, false);
        validateString(title.getFromDate(), "From Date", TITLE_DATE, false);
        validateString(title.getToDate(), "To Date", TITLE_DATE, false);
    }

    private void validateString(String value, String fieldName, int maxLength, boolean isNullAllowed) {
        if (value == null && isNullAllowed) {
            // null permitted, nothing to validate
        } else if (value == null) {
            if (!isNullAllowed) {
                throw new IllegalArgumentException(String.format("%s cannot be null", fieldName));
            }
        } else if (value.isEmpty()) {
            throw new IllegalArgumentException(String.format("%s cannot be empty or only whitespace", fieldName));
        } else if (value.length() > maxLength) {
            throw new IllegalArgumentException(String.format("%s cannot exceed %d characters", fieldName, maxLength));
        }
    }
}
