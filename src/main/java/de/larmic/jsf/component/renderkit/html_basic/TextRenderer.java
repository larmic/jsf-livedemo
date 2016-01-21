package de.larmic.jsf.component.renderkit.html_basic;

import de.larmic.jsf.component.html.UIText;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import java.io.IOException;

@FacesRenderer(componentFamily = UIText.COMPONENT_FAMILY, rendererType = UIText.RENDERER_TYPE)
public class TextRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        final ResponseWriter writer = context.getResponseWriter();

        writer.startElement("div", component);
        writer.writeAttribute("style", "text-input", "styleClass");
        writer.writeText("my first component", component, null);
    }

    @Override
    public boolean getRendersChildren() {
        return true;
    }

    @Override
    public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
        // do not encode children
    }

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
        final ResponseWriter writer = context.getResponseWriter();

        writer.endElement("div");
    }
}
