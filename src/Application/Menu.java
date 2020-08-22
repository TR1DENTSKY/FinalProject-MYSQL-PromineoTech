package Application;

import DAO.AttachmentDAO;
import DAO.CaliberDAO;
import DAO.TypeDAO;
import DAO.WeaponDAO;


import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {

    private WeaponDAO weaponDAO = new WeaponDAO();
    private TypeDAO typeDAO = new TypeDAO();
    private CaliberDAO caliberDAO = new CaliberDAO();
    private AttachmentDAO attachmentDAO = new AttachmentDAO();

    private Scanner scanner = new Scanner(System.in);
    private List<String> options = Arrays.asList(
            "Add a Gun",
            "Add Types",
            "Add Calibers",
            "Add Attachments",
            "Update a Gun",
            "Update the Type",
            "Update the Caliber",
            "Update Attachment",
            "Remove a Gun",
            "Remove a Type",
            "Remove a Caliber",
            "Remove an Attachment",
            "Display Guns",
            "Display Types",
            "Display Calibers",
            "Display Attachments"
    );

    public void start() {

        String selection = "";

        do {
            printMenu();
            System.out.print("\nPlease enter option: ");
            selection = scanner.nextLine();
            System.out.println();

            try {
                if (selection.equals("1")) {
                    addGuns();
                } else if (selection.equals("2")) {
                    addTypes();
                } else if (selection.equals("3")) {
                    addCalibers();
                } else if (selection.equals("4")) {
                    addAttachments();
                } else if (selection.equals("5")) {
                    updateGuns();
                } else if (selection.equals("6")) {
                    updateTypes();
                } else if (selection.equals("7")) {
                    updateCalibers();
                } else if (selection.equals("8")) {
                    updateAttachments();
                } else if (selection.equals("9")) {
                    removeGuns();
                } else if (selection.equals("10")) {
                    removeTypes();
                }  else if (selection.equals("11")) {
                    removeCalibers();
                }  else if (selection.contentEquals("12")) {
                    removeAttachments();
                } else if (selection.equals("13")) {
                    displayGuns();
                }  else if (selection.equals("14")) {
                    displayTypes();
                } else if (selection.equals("15")) {
                    displayCalibers();
                }  else if (selection.contentEquals("16")) {
                    displayAttachments();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println("Press enter to continue...");
            selection =  scanner.nextLine();


        } while (!selection.equals("-1"));
    }

	private void printMenu() {
        System.out.println("Select an Option:\n-------------------");
        for (int i = 0; i < options.size(); i++) {
            System.out.println(i + 1 + ")" + options.get(i));
        }
    }

	private void addGuns() throws SQLException {
		System.out.print("Add Gun ID:");
		int gunId = Integer.parseInt(scanner.nextLine());
		System.out.print("Add Gun Name:");
		String gun = scanner.nextLine();
		WeaponDAO.addNewWeapon(gunId, gun);
	}
	
	private void addTypes() throws SQLException {
		System.out.print("Add ID Type:");
		int typeId = Integer.parseInt(scanner.nextLine());
		System.out.print("Add Weapon Type:");
		String weapon_type = scanner.nextLine();
		TypeDAO.createNewType(typeId, weapon_type);
	}
	
	private void addCalibers() throws SQLException {
		System.out.print("Add Caliber:");
		int caliberId = Integer.parseInt(scanner.nextLine());
		System.out.print("Add Caliber Type:");
		int caliberType = Integer.parseInt(scanner.nextLine());
		CaliberDAO.addNewCaliber(caliberId, caliberType);
	}
	
	private void addAttachments() throws SQLException {
		System.out.print("Add Attachment:");
		int attachmentId = Integer.parseInt(scanner.nextLine());
		System.out.print("Add Attachment Type:");
		String attachmentType = scanner.nextLine();
		AttachmentDAO.addNewAttachment(attachmentId, attachmentType);
	}
	
	private void updateGuns() throws SQLException {
		System.out.print("Update Gun ID:");
		int gunId = Integer.parseInt(scanner.nextLine());
		System.out.print("Update Gun:");
		String gun = scanner.nextLine();
		WeaponDAO.updateWeapon(gunId, gun);
	}
	
	private void updateTypes() throws SQLException {
		System.out.print("Update ID Type:");
		int typeId = Integer.parseInt(scanner.nextLine());
		System.out.print("Update Weapon Type:");
		String weaponType = scanner.nextLine();
		TypeDAO.updateType(typeId, weaponType);
	}
	
	private void updateCalibers() throws SQLException {
		System.out.print("Update Caliber:");
		int caliberId = Integer.parseInt(scanner.nextLine());
		System.out.print("Update Caliber Type:");
		int caliberType = Integer.parseInt(scanner.nextLine());
		CaliberDAO.updateCaliber(caliberId, caliberType);
	}
	
	private void updateAttachments() throws SQLException {
		System.out.print("Update Attachment:");
		int attachmentId = Integer.parseInt(scanner.nextLine());
		System.out.print("Update Attachment Type:");
		String attachmentType = scanner.nextLine();
		AttachmentDAO.updateAttachment(attachmentId, attachmentType);
	}
	
	private void removeGuns() throws SQLException {
		System.out.print("Delete By Gun ID:");
		int gunId = Integer.parseInt(scanner.nextLine());
		//System.out.print("Delete By Gun Name:");
		//String gun = scanner.nextLine();
		WeaponDAO.deleteWeaponById(gunId);
	}
	
	private void removeTypes() throws SQLException {
		System.out.print("Delete Type By ID:");
		int typeId = Integer.parseInt(scanner.nextLine());
		//System.out.print("Delete By Weapon Type:");
		//String weaponType = scanner.nextLine();
		TypeDAO.deleteTypeById(typeId);
	}
	
	private void removeCalibers() throws SQLException {
		System.out.print("Delete By Caliber:");
		int caliberId = Integer.parseInt(scanner.nextLine());
		//System.out.print("Delete By Caliber Type:");
		//String caliberType = scanner.nextLine();
		CaliberDAO.deleteCaliberById(caliberId);
	}
	
	private void removeAttachments() throws SQLException {
		System.out.print("Enter New Attachment:");
		int attachmentId = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Attachment Type:");
		String attachmentType = scanner.nextLine();
		AttachmentDAO.removeAttachments(attachmentId, attachmentType);
	}
	
	private void displayGuns() throws SQLException {
		System.out.print("Enter New Gun ID:");
		int gunId = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Gun Name:");
		String gun = scanner.nextLine();
		WeaponDAO.displayGuns(gunId, gun);
	}
	
	private void displayTypes() throws SQLException {
		System.out.print("Enter New ID Type:");
		int typeId = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Weapon Type:");
		String weaponType = scanner.nextLine();
		TypeDAO.displayTypes(typeId, weaponType);
	}
	
	private void displayCalibers() throws SQLException {
		System.out.print("Enter New Caliber:");
		int caliberId = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Caliber Type:");
		String caliberType = scanner.nextLine();
		CaliberDAO.displayCalibers(caliberId, caliberType);
	}
	
	private void displayAttachments() throws SQLException {
		System.out.print("Enter New Attachment:");
		int attachmentId = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter New Attachment Type:");
		String attachmentType = scanner.nextLine();
		AttachmentDAO.displayAttachments(attachmentId, attachmentType);
	}

}
