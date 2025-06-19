package lab.requests.backing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.html.HtmlDataTable;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.transaction.Transactional;
import jakarta.validation.constraints.Size;
import lab.requests.data.RequestRepository;
import lab.requests.entities.Request;

import java.time.LocalDate;
import java.util.List;

@Named
@RequestScoped
public class RequestsList {
    @Inject
    private RequestRepository requestRepository;

    @Size(min = 3, max = 60, message = "Request text must be from 3 to 60 characters long.")
    private String newRequest;
    private HtmlDataTable requestsDataTable;

    public List<Request> getAllRequests() {
        return requestRepository.findAll();
    }

    public String getNewRequest() {
        return newRequest;
    }

    public void setNewRequest(String newRequest) {
        this.newRequest = newRequest;
    }

    public HtmlDataTable getRequestsDataTable() {
        return requestsDataTable;
    }

    public void setRequestsDataTable(HtmlDataTable requestsDataTable) {
        this.requestsDataTable = requestsDataTable;
    }

    @Transactional
    public String addRequest() {
        Request request = new Request();
        request.setRequestDate(LocalDate.now());
        request.setRequestText(newRequest);

        requestRepository.create(request);
        setNewRequest("");

        return "requestsList?faces-redirect=true";
    }

    @Transactional
    public String deleteRequest(Request request) {

        requestRepository.remove(request);
        newRequest = "";

        return "requestsList?faces-redirect=true";
    }

}
