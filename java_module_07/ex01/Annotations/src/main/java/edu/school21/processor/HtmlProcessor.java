package edu.school21.processor;

import javax.annotation.processing.*;
import javax.tools.StandardLocation;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.Element;
import java.io.*;
import java.util.*;
import edu.school21.annotations.HtmlForm;
import edu.school21.annotations.HtmlInput;
import edu.school21.form.UserForm;

@SupportedAnnotationTypes({"HtmlForm", "HtmlInput"})
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class HtmlProcessor extends AbstractProcessor
{

	@Override
	public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv)
	{
		for (Element element : roundEnv.getElementsAnnotatedWith(HtmlForm.class))
		{
			HtmlForm formAnnotation = element.getAnnotation(HtmlForm.class);
			String fileName = formAnnotation.fileName();
			String action = formAnnotation.action();
			String method = formAnnotation.method();
			
			StringBuilder htmlBuilder = new StringBuilder();
			htmlBuilder.append("<form action=\"" + action + "\" method=\"" + method + "\">");

			// Process fields annotated with @HtmlInput
			for (Element field : element.getEnclosedElements())
			{
				if (field.getAnnotation(HtmlInput.class) != null)
				{
					HtmlInput inputAnnotation = field.getAnnotation(HtmlInput.class);
					String type = inputAnnotation.type();
					String name = inputAnnotation.name();
					String placeholder = inputAnnotation.placeholder();

					htmlBuilder.append("<input type=\"" + type + "\" name=\"" + name + "\" placeholder=\"" + placeholder + "\">");
				}
			}

			htmlBuilder.append("<input type=\"submit\" value=\"Send\">");
			htmlBuilder.append("</form>");

			try (Writer writer = processingEnv.getFiler().createResource(StandardLocation.CLASS_OUTPUT, "", fileName).openWriter())
			{
				writer.write(htmlBuilder.toString());
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		return true;
	}

}
