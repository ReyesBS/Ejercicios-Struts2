package org.demo.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import org.demo.actions.beans.InvoiceBean;

import java.util.Date;

public class InvoiceAction extends ActionSupport  implements Preparable {

    private InvoiceBean invoiceBean;


    public InvoiceBean getInvoiceBean() {
        return invoiceBean;
    }

    public void setInvoiceBean(InvoiceBean invoiceBean) {

        this.invoiceBean = invoiceBean;

    }

    @Override
    public void validate() {
        if (invoiceBean.getSubject().isEmpty()) {

            addFieldError("invoiceBean.subject", "El concepto es obligatorio.");
        }

        if(invoiceBean.getDateTo() == null){
            addFieldError("invoiceBean.dateFrom", "Debe seleccionar una fecha de inicio de factura.");
        }
        if(invoiceBean.getDateFrom() == null){
            addFieldError("invoiceBean.dateTo", "Debe seleccionar una fecha de fin de factura.");
        }
        if (invoiceBean.getAmount() < 0.1) {
            addFieldError("invoiceBean.amount", "El importe bruto debe ser superior a 0.");
        }else{
            System.out.println("Amount de validacion: " + invoiceBean.getAmount());
            //El valor lo manda correctamente sin IVA
        }
    }


    @Override
    public String execute() throws Exception {
        System.out.println("execute!!");
        invoiceBean.setAmount(invoiceBean.getAmount() * 0.21);
        System.out.println("Amount de execute " + invoiceBean.getAmount());
        return SUCCESS;
        //El valor lo multiplica y muestra correctamente
    }
}
