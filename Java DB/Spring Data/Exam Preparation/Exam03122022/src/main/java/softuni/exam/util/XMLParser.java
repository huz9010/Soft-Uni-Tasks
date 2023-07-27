package softuni.exam.util;


import javax.xml.bind.JAXBException;


import java.io.FileNotFoundException;

public interface XMLParser {

    <T> T readFromXml(String filePath, Class<T> tClass) throws FileNotFoundException, JAXBException;

    <T> void writeToXml(String filePath, T entity) throws JAXBException;
}
