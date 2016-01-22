package de.larmic.jsf.component.renderkit.html_basic;

import de.larmic.jsf.component.html.UIText;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;
import java.io.IOException;
import java.util.Map;

@FacesRenderer(componentFamily = UIText.COMPONENT_FAMILY, rendererType = UIText.RENDERER_TYPE)
public class TextRenderer extends Renderer {

    @Override
    public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
        final ResponseWriter writer = context.getResponseWriter();

        final UIText text = (UIText) component;

        writer.startElement("div", text);
        writer.writeAttribute("class", "text-input", "styleClass");

        writer.startElement("label", text);
        writer.writeText(text.getLabel(), text, null);
        writer.endElement("label");

        writer.startElement("br", text);
        writer.endElement("br");

        writer.startElement("input", text);
        writer.writeAttribute("name", component.getClientId(context), "clientId");
        if (text.getPlaceholder() != null && !"".equals(text.getPlaceholder())) {
            writer.writeAttribute("placeholder", text.getPlaceholder(), null);
        }
        writer.endElement("input");
    }

    @Override
    public void decode(FacesContext context, UIComponent component) {
        if (!component.isRendered()) {
            return;
        }

        final String clientId = component.getClientId(context);

        final Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();

        final String newValue = requestMap.get(clientId);
        if (newValue != null) {
            ((UIText) component).setValue(newValue);
        }
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
