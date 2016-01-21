package de.larmic.jsf.component.html;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

@FacesComponent(UIText.COMPONENT_TYPE)
public class UIText extends UIComponentBase {

    public static final String COMPONENT_TYPE = "de.larmic.jsf.livedemo.text";
    public static final String RENDERER_TYPE = "de.larmic.jsf.livedemo.text.renderer";
    public static final String COMPONENT_FAMILY = "de.larmic.jsf.livedemo.family";

    public UIText() {
        super();
        setRendererType(RENDERER_TYPE);
    }

    @Override
    public String getFamily() {
        return COMPONENT_FAMILY;
    }
}