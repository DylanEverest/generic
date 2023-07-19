package generic;

import java.util.ArrayList;

import generic.jsp.Form;

public class Generic extends Reflect{
    
    protected String cssForm ;
    protected String actionForm;
    protected String methodForm;
    protected String btnValueForm ;


    public Generic()
    {
    
        Form form = new Form() ;
        cssForm = form.getCSS();
        btnValueForm ="Envoyer";
    
    }

    private String [] getAttributeName(String... ignore)
    {
        ignore= getIgnore(ignore) ;
        return super.getAttributeName(this, ignore) ;
    }


    private Object [] getAttributeValue(String... ignore)
    {
        ignore = getIgnore(ignore);
        return super.getAttributeValue(this, ignore);
    }


    protected String getFormHTML(String action , String method , String... ignore)
    {
        String [] fieldsName = getAttributeName(ignore);
        Object [] fildsValue = getAttributeValue(ignore);


        Form formGeneric = new Form();
        String form = formGeneric.getForm(action, method ,"Valider");
        String formElements = formGeneric.getFormElements(fieldsName, fieldsName, fildsValue);
    
        
        return formGeneric.getHTMLForm(getCssForm(), form, formElements) ;
    }

    // 
    private String [] getIgnore (String ... ignore)
    {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < ignore.length; i++) 
        {
            list.add(ignore[i]);
        }
        list.add(btnValueForm);
        list.add(actionForm);
        list.add(methodForm);
        list.add(cssForm);

        return list.toArray(new String [list.size()]);

    }



    // settes and getters

    public String getCssForm() 
    {
        return cssForm;
    }

    public void setCssForm(String cssForm) 
    {
        this.cssForm = cssForm;
    }

    public String getActionForm() {
        return actionForm;
    }

    public void setActionForm(String actionForm) 
    {
        this.actionForm = actionForm;
    }

    public String getMethodForm() 
    {
        return methodForm;
    }

    public void setMethodForm(String methodForm) 
    {
        this.methodForm = methodForm;
    }

    public String getBtnValueForm() 
    {
        return btnValueForm;
    }

    public void setBtnValueForm(String btnValueForm) 
    {
        this.btnValueForm = btnValueForm;
    }

    




}