package de.larmic.jsf.component.renderkit.html_basic;

import de.larmic.jsf.component.html.UIText;

import javax.faces.render.FacesRenderer;
import javax.faces.render.Renderer;

@FacesRenderer(componentFamily = UIText.COMPONENT_FAMILY, rendererType = UIText.RENDERER_TYPE)
public class TextRenderer extends Renderer {
}
