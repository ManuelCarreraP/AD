package PrimerTrimestre.P4_SerializacionXML.Parte3;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CrearAutoresXML {
    public static void main(String[] args) {
        try {
            // Crear factory y writer
            XMLOutputFactory factory = XMLOutputFactory.newInstance();
            XMLStreamWriter writer = factory.createXMLStreamWriter(new FileWriter("autores.xml"));

            // Escribir documento XML
            writer.writeStartDocument("1.0");
            writer.writeStartElement("autores");

            // Primer autor
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a1");

            writer.writeStartElement("nome");
            writer.writeCharacters("Alexandre Dumas");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("El conde de montecristo");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("Los miserables");
            writer.writeEndElement();

            writer.writeEndElement(); // Cerrar autor

            // Segundo autor
            writer.writeStartElement("autor");
            writer.writeAttribute("codigo", "a2");

            writer.writeStartElement("nome");
            writer.writeCharacters("Fiodor Dostoyevski");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("El idiota");
            writer.writeEndElement();

            writer.writeStartElement("titulo");
            writer.writeCharacters("Noches blancas");
            writer.writeEndElement();

            writer.writeEndElement(); // Cerrar autor

            // Cerrar elementos
            writer.writeEndElement(); // Cerrar autores
            writer.writeEndDocument();

            // Cerrar writer
            writer.close();

            System.out.println("Documento XML 'autores.xml' creado correctamente.");

        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }
    }
}