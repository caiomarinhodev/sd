package models;
 
import com.fasterxml.jackson.databind.JsonNode;
 
/**
 * Created by caio on 09/03/15.
 */
public class UsuarioFacebook {
 
    private Long id;
    private String firstName;
    private Integer timezone;
    private String email;
    private Boolean verified;
    private String middleName;
    private String gender;
    private String lastName;
    private String link;
    private String locale;
    private String name;
    private String updatedTime;
 
    public UsuarioFacebook(JsonNode jsonUsuario){
 
        id = jsonUsuario.findPath("id").longValue();
        firstName = jsonUsuario.findPath("first_name").textValue();
        timezone = jsonUsuario.findPath("timezone").intValue();
        email = jsonUsuario.findPath("email").textValue();
        verified = jsonUsuario.findPath("verified").booleanValue();
        middleName = jsonUsuario.findPath("middle_name").textValue();
        gender = jsonUsuario.findPath("gender").textValue();
        lastName = jsonUsuario.findPath("last_name").textValue();
        link = jsonUsuario.findPath("link").textValue();
        locale = jsonUsuario.findPath("locale").textValue();
        name = jsonUsuario.findPath("name").textValue();
        updatedTime = jsonUsuario.findPath("updated_time").textValue();
    }
 
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }
 
    public String getFirstName() {
        return firstName;
    }
 
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    public Integer getTimezone() {
        return timezone;
    }
 
    public void setTimezone(Integer timezone) {
        this.timezone = timezone;
    }
 
    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
 
    public Boolean getVerified() {
        return verified;
    }
 
    public void setVerified(Boolean verified) {
        this.verified = verified;
    }
 
    public String getMiddleName() {
        return middleName;
    }
 
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }
 
    public String getGender() {
        return gender;
    }
 
    public void setGender(String gender) {
        this.gender = gender;
    }
 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
 
    public String getLink() {
        return link;
    }
 
    public void setLink(String link) {
        this.link = link;
    }
 
    public String getLocale() {
        return locale;
    }
 
    public void setLocale(String locale) {
        this.locale = locale;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getUpdatedTime() {
        return updatedTime;
    }
 
    public void setUpdatedTime(String updatedTime) {
        this.updatedTime = updatedTime;
    }
 
    @Override
    public String toString() {
        return "UsuarioFacebook [id=" + id + ", firstName=" + firstName
                + ", timezone=" + timezone + ", email=" + email + ", verified="
                + verified + ", middleName=" + middleName + ", gender="
                + gender + ", lastName=" + lastName + ", link=" + link
                + ", locale=" + locale + ", name=" + name + ", updatedTime="
                + updatedTime + "]";
    }
 
}