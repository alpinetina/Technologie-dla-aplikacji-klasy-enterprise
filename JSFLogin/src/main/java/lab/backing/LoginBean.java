package lab.backing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.component.html.HtmlCommandButton;
import jakarta.faces.component.html.HtmlSelectBooleanCheckbox;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.AjaxBehaviorEvent;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Named;

@Named
@RequestScoped
public class LoginBean {

    private String username;
    private String password;

    private HtmlSelectBooleanCheckbox acceptCheckbox;
    private HtmlCommandButton loginButton;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public HtmlSelectBooleanCheckbox getAcceptCheckbox() {
        return acceptCheckbox;
    }

    public void setAcceptCheckbox(HtmlSelectBooleanCheckbox acceptCheckBox) {
        this.acceptCheckbox = acceptCheckBox;
    }

    public HtmlCommandButton getLoginButton() {
        return loginButton;
    }

    public void setLoginButton(HtmlCommandButton loginButton) {
        this.loginButton = loginButton;
    }

    public String login() {
        if (username != null && username.equals(password)) {
            return "success";
        } else {
            return "failure";
        }
    }

    public void activateButton(AjaxBehaviorEvent event) {
        if (acceptCheckbox.isSelected()) {
            loginButton.setDisabled(false);
        } else {
            loginButton.setDisabled(true);
        }
        FacesContext.getCurrentInstance().renderResponse();
    }

}
