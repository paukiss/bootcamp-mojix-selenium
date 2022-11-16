package testSuite.todoist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CRUDProjectTest extends TestBase{
    @Test
    public void test(){
        String email = "sergio_mojix@bootcamp.com";
        String pass = "123456789abc";

        loginSession.loginButton.click();
        loginPageSession.emailTxt.setText(email);
        loginPageSession.pwdTxt.setText(pass);
        loginPageSession.loginButton.click();
        mainPage.projectLabel.waitControlIsNotVisibleElement();
        Assertions.assertTrue(mainPage.projectLabel.isControlDisplayed(), "Error! Log in failed");

        String nameProject = "nuevo project sergio";
        projectsPage.newProject.click();
        projectsPage.addProject.click();
        projectsPage.nameProject.setText(nameProject);
        projectsPage.addNewProject.click();
        Assertions.assertFalse(projectsPage.addNewProject.isControlDisplayed(), "Error! Project was not created");

        String updateNameProject = "update name project";
        projectsPage.clickOnNameProject(nameProject);
        projectsPage.newNameProject.cleanSetText(updateNameProject);
        projectsPage.saveProject.click();
        Assertions.assertFalse(projectsPage.saveProject.isControlDisplayed(), "Error! Project was not updated");

        optionsProjectPage.optionsProject.click();
        optionsProjectPage.deleteOption.click();
        optionsProjectPage.confirmDelete.click();
        Assertions.assertEquals(projectsPage.nameProjectHeader.getText(), "Inbox", "Error! Project was not deleted");
    }
}
