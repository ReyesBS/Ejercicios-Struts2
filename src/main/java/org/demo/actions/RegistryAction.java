package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import org.demo.actions.beans.InvoiceBean;


/**
 * <code>Set welcome message.</code>
 */
public class RegistryAction extends ActionSupport {

    private InvoiceBean invoiceBean = new InvoiceBean();


    @Override
        public String execute(){
            return SUCCESS;
        }

    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {
        this.invoiceBean = invoiceBean;


    }



}