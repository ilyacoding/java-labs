package by.bsuir.ilyacoding.Server.dao.xml;

import by.bsuir.ilyacoding.Server.dao.AffairDAO;
import by.bsuir.ilyacoding.Server.dao.exception.DAOException;
import by.bsuir.ilyacoding.Server.domain.Affair;
import by.bsuir.ilyacoding.Server.domain.AffairArchive;

import javax.xml.bind.*;
import java.io.File;
import java.util.ListIterator;

public class XmlAffairDAO implements AffairDAO {

    @Override
    public Affair getAffairById(int id) throws DAOException {
        AffairArchive archive = getAll();

        if (archive == null) {
            return null;
        }

        return archive.getList().stream().filter((affair) -> affair.getId() == id).findFirst().orElse(null);
    }

    @Override
    public void addAffair(Affair affair) throws DAOException {
        AffairArchive archive = getAll();

        if (archive == null) {
            archive = new AffairArchive();
        }

        archive.getList().add(affair);

        try {
            writeArchive(archive);
        }
        catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void updateAffairById(int id, Affair Affair) throws DAOException {
        AffairArchive archive = getAll();

        if (archive == null) {
            throw new DAOException("Affair list is empty.");
        }

        ListIterator<Affair> iter = archive.getList().listIterator();

        boolean AffairHasBeenUpdate = false;

        while (iter.hasNext()) {

            if (iter.next().getId() == id) {
                iter.set(Affair);
                AffairHasBeenUpdate = true;
                break;
            }

        }

        if (!AffairHasBeenUpdate) {
            throw new DAOException("Affair update failed.");
        }

        try {
            writeArchive(archive);
        }
        catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public void deleteAffairById(int id) throws DAOException {
        AffairArchive archive = getAll();

        if (archive == null) {
            throw new DAOException("Affair list is empty.");
        }

        ListIterator<Affair> iter = archive.getList().listIterator();

        boolean AffairHasBeenDeleted = false;

        while (iter.hasNext()) {

            if (iter.next().getId() == id) {
                iter.remove();
                AffairHasBeenDeleted = true;
                break;
            }

        }

        if (!AffairHasBeenDeleted) {
            throw new DAOException("Affair delete failed.");
        }

        try {
            writeArchive(archive);
        }
        catch (JAXBException e) {
            throw new DAOException(e);
        }
    }

    @Override
    public AffairArchive getAll() throws DAOException {
        try {

            JAXBContext jc = JAXBContextFactory.getContext();
            Unmarshaller unmarshaller = jc.createUnmarshaller();

            return (AffairArchive) unmarshaller.unmarshal(new File(JAXBContextFactory.getAffairFile()));

        } catch (UnmarshalException ignored) {
            return null;
        } catch (JAXBException e) {
            throw new DAOException(e);
        }

    }

    private void writeArchive(AffairArchive archive) throws DAOException, JAXBException {
        JAXBContext jc = JAXBContextFactory.getContext();
        Marshaller marshaller = jc.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(archive, new File(JAXBContextFactory.getAffairFile()));
    }
}
