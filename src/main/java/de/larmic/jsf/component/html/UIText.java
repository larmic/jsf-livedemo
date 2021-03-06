package de.larmic.jsf.component.html;

import javax.el.ValueExpression;
import javax.faces.application.ResourceDependencies;
import javax.faces.application.ResourceDependency;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

@ResourceDependencies(
        @ResourceDependency(library = "component-css", name = "text.css", target = "head")
)
@FacesComponent(UIText.COMPONENT_TYPE)
public class UIText extends UIComponentBase {

    public static final String COMPONENT_TYPE = "de.larmic.jsf.livedemo.text";
    public static final String RENDERER_TYPE = "de.larmic.jsf.livedemo.text.renderer";
    public static final String COMPONENT_FAMILY = "de.larmic.jsf.livedemo.family";

    protected static final String PROPERTY_VALUE = "value";
    protected static final String PROPERTY_LABEL = "label";
    protected static final String PROPERTY_PLACEHOLDER = "placeholder";

    public UIText() {
        super();
        setRendererType(RENDERER_TYPE);
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }

    public Object getValue() {
        return this.getStateHelper().eval(PROPERTY_VALUE);
    }

    public void setValue(final Object value) {
        this.updateStateHelper(PROPERTY_VALUE, value);
    }

    public String getLabel() {
        return (String) this.getStateHelper().eval(PROPERTY_LABEL);
    }

    public void setLabel(final String title) {
        this.updateStateHelper(PROPERTY_LABEL, title);
    }

    public String getPlaceholder() {
        return (String) this.getStateHelper().eval(PROPERTY_PLACEHOLDER);
    }

    public void setPlaceholder(final String placeholder) {
        this.updateStateHelper(PROPERTY_PLACEHOLDER, placeholder);
    }

    protected void updateStateHelper(final String propertyName, final Object value) {
        this.getStateHelper().put(propertyName, value);

        final ValueExpression ve = this.getValueExpression(propertyName);

        if (ve != null) {
            ve.setValue(this.getFacesContext().getELContext(), value);
        }
    }
}
