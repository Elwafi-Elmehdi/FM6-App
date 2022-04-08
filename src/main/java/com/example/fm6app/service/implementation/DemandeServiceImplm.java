package com.example.fm6app.service.implementation;

import com.example.fm6app.domain.Critere;
import com.example.fm6app.domain.Demande;
import com.example.fm6app.domain.Enfant;
import com.example.fm6app.domain.Fonction;
import com.example.fm6app.repository.DemandeRepository;
import com.example.fm6app.service.dto.DemandeDTO;
import com.example.fm6app.service.facade.CritereService;
import com.example.fm6app.service.facade.DemandeService;
import com.example.fm6app.service.utils.StringUtil;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.hibernate.loader.custom.Return;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class DemandeServiceImplm implements DemandeService {

    private DemandeRepository demandeRepo;
    private CritereService critereService;
    private Critere critere;
    private EntityManager entityManager;

    @Autowired
    public DemandeServiceImplm(DemandeRepository demandeRepo, CritereService critereService, EntityManager entityManager) {
        this.demandeRepo = demandeRepo;
        this.critereService = critereService;
        this.critere = critereService.findOne();
        this.entityManager = entityManager;
    }



    @Override
    public List<Demande> findAll() {
        return demandeRepo.findAll(Sort.by("score").descending());
    }

    @Override
    public Demande findByCin(String cin) {
        return demandeRepo.findByCin(cin);
    }

    @Override
    public Demande findByCodeAdherentCode(String code) {
        return demandeRepo.findByAdherentCode(code);
    }

    @Override
    public Demande findByFonction(Fonction fonction) {
        return demandeRepo.findByFonction(fonction);
    }

    @Override
    public Demande findByAgeLessThanEqual(long age) {
        return demandeRepo.findByAgeIsLessThanEqual(age);
    }

    @Override
    public Demande findByAncienneteLessThanEqual(long anciennete) {
        return demandeRepo.findByAncienneteIsLessThanEqual(anciennete);
    }
    @Transactional
    @Override
    public Demande save(Demande demande) {
        if(demandeRepo.findByCin(demande.getCin()) != null)
            return null;
        else{
            demande = generateDemande(demande);
            demande.setScore(generateScore(demande));
            return demandeRepo.save(demande);
        }
    }
    @Transactional
    @Override
    public Demande delete(Demande demande) {
        if(demandeRepo.findById(demande.getId()).get() == null)
            return null;
        else{
            demandeRepo.deleteById(demande.getId());
            return demande;
        }
    }
    @Transactional
    @Override
    public Demande update(Demande demande) {
        Optional<Demande> dbDemande = demandeRepo.findById(demande.getId());
        if(dbDemande.isEmpty()){
            return null;
        }else if (!dbDemande.get().getCin().equalsIgnoreCase(demande.getCin()))
            return  null;
        else{
            demande.setScore(generateScore(demande));
            return demandeRepo.save(demande);
        }
    }

    @Override
    public List<Demande> findByCriteria(DemandeDTO dto) {
        String query = "SELECT o FROM Demande o where 1=1 ";
        query += StringUtil.addConstraint( "o", "cin","=",dto.getCin());
        query += StringUtil.addConstraint( "o", "telephone","LIKE",dto.getTelephone());
        query += StringUtil.addConstraint( "o", "adherent_code","LIKE", dto.getCodeAdherent());
        query += StringUtil.addConstraint("o","age","<=",dto.getAge());
        query += StringUtil.addConstraint("o","anciennete","<=",dto.getAnciennete());
        query += StringUtil.addConstraint("o","fonction","=",dto.getFonction() == null?null:dto.getFonction().ordinal());
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ResponseEntity<byte[]> generateXlsRepory(int year) throws IOException {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("CLASSIFICATION");
        setColumnsWidth(sheet);

        int rownum = 0;
        Cell cell;
        Row row;
        HSSFCellStyle style = createStyleForTitle(workbook);
        row = sheet.createRow(rownum);
        List<Demande> demandes = demandeRepo.findByDateCustom(year);

        cell = row.createCell(0, CellType.STRING);
        cell.setCellValue("الاستحقاق");
        cell.setCellStyle(style);

        cell = row.createCell(1, CellType.STRING);
        cell.setCellValue("رقم البطاقة الوطنية");
        cell.setCellStyle(style);

        cell = row.createCell(2, CellType.STRING);
        cell.setCellValue("رقم الانخراط");
        cell.setCellStyle(style);

        cell = row.createCell(3, CellType.STRING);
        cell.setCellValue("الاسم العائلي بالعربية لصاحب الطلب");
        cell.setCellStyle(style);

        cell = row.createCell(4, CellType.STRING);
        cell.setCellValue("الاسم الشخصي بالعربية لصاحب الطلب");
        cell.setCellStyle(style);

        cell = row.createCell(5, CellType.STRING);
        cell.setCellValue("الاسم العائلي بالفرنسية لصاحب الطلب");
        cell.setCellStyle(style);

        cell = row.createCell(6, CellType.STRING);
        cell.setCellValue("الاسم الشخصي بالفرنسية لصاحب الطلب");
        cell.setCellStyle(style);

        cell = row.createCell(7, CellType.STRING);
        cell.setCellValue("رقم الهاتف");
        cell.setCellStyle(style);

        cell = row.createCell(8, CellType.STRING);
        cell.setCellValue("الإقليم");
        cell.setCellStyle(style);

        cell = row.createCell(9,CellType.STRING);
        cell.setCellValue("رقم الحساب البنكي");
        cell.setCellStyle(style);

        for (Demande demande : demandes){
            rownum++;
            row = sheet.createRow(rownum);

            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue(demande.getScore());

            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue(demande.getCin());

            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue(demande.getAdherentCode());

            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue(demande.getNomArabic());

            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue(demande.getPrenomArabic());

            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue(demande.getNom());

            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue(demande.getPrenom());

            cell = row.createCell(7,CellType.STRING);
            cell.setCellValue(demande.getTelephone());

            cell = row.createCell(8,CellType.STRING);
            cell.setCellValue(demande.getProvince());

            cell = row.createCell(9,CellType.STRING);
            cell.setCellValue(demande.getRib());

        }
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        out.close();
        workbook.close();
        return createResponseEntity(out.toByteArray(),"report.xls");
    }
    private ResponseEntity<byte[]>  createResponseEntity(byte[] report, String fileName){
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet;charset=UTF-8"))
                .contentLength(report.length)
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename="+ "\"" + fileName+ "\"")
                .body(report);
    }
    private void setColumnsWidth(Sheet sheet) {
        sheet.setColumnWidth(0, 256 * 20);

        for (int i = 1;i<7; i++) {
            sheet.setColumnWidth(i, 256 * 15);
        }
    }

    private HSSFCellStyle createStyleForTitle(HSSFWorkbook workbook) {
        HSSFFont font = workbook.createFont();
        font.setBold(true);
        HSSFCellStyle style = workbook.createCellStyle();
        style.setFont(font);
        style.setWrapText(true);
        return style;
    }
    private int generateScore(Demande demande) {
        int score = 0;
        score += getEnvironementScore(demande);
        score += getLogementScore(demande);
        score += getSfScore(demande);
        score += getFonctionScore(demande);
        score += getConditionPhysiqueScore(demande);
        score += getEnfantsScore(demande);
        score += getAncienneteAndAge(demande);
        return score;
    }

    private Demande generateDemande(Demande demande){

        Demande demandeDao = new Demande();
        demandeDao.setReference(demande.getCin()+ RandomStringUtils.randomAlphanumeric(5));
        demandeDao.setNaissance(demande.getNaissance());
        demandeDao.setNom(demande.getNom());
        demandeDao.setPrenom(demande.getPrenom());
        demandeDao.setCin(demande.getCin());
        demandeDao.setAdherentCode(demande.getAdherentCode());
        demandeDao.setTelephone(demande.getTelephone());
        demandeDao.setAdresseActualle(demande.getAdresseActualle());
        demandeDao.setMosque(demande.getMosque());
        demandeDao.setMosqueRef(demande.getMosqueRef());
        demandeDao.setDateJoindreMosque(demande.getDateJoindreMosque());
        demandeDao.setProvince(demande.getProvince());
        demandeDao.setNomArabic(demande.getNomArabic());
        demandeDao.setPrenomArabic(demande.getPrenomArabic());
        demandeDao.setRib(demande.getRib());

        demandeDao.setEnvironment(demande.getEnvironment());
        demandeDao.setSf(demande.getSf());
        demandeDao.setFonction(demande.getFonction());
        demandeDao.setConditionPhysique(demande.getConditionPhysique());
        demandeDao.setLogement(demande.getLogement());

        return demandeDao;
    }


    private int getFonctionScore(Demande demande){
        switch (demande.getFonction()){
            case IMAME:
                return critere.getFonctionImame();
            case KHATIB:
                return critere.getFonctionKhatib();
            case GARDIEN:
                return critere.getFonctionGardien();
            case OBCERBATEUR:
                return critere.getFonctionObservateur();
            case MENAGE:
                return critere.getFonctionMenage();
            case MOADIN:
                return critere.getFonctionMoadin();
            case PRECHEUR:
                return critere.getGuideEncadrentPrecheur();
            default:
                return 0;
        }
    }

    private int getSfScore(Demande demande){
        switch (demande.getSf()){
            case VEUF:
                return critere.getSfVeuf();
            case MARIE:
                return critere.getSfMarie();
            case DIVORCE:
                return critere.getSfDivorce();
            case CELIBATAIRE:
                return critere.getSfCelibataire();
            default:
                return 0;
        }
    }

    private int getLogementScore(Demande demande){
        switch (demande.getLogement()){
            case LOUER:
                return critere.getLogementLouer();
            case FAMILLE:
                return critere.getLogementFamille();
            case ANNEXE_MOSQUE:
                return critere.getLogementAnnexeMosque();
            default:
                return 0;
        }
    }
    private int getEnvironementScore(Demande demande){
        switch (demande.getEnvironment()){
            case CIVIL:
                return critere.getEnvironnementCivil();
            case RURAL:
                return critere.getEnvironnementRural();
            default:
                return  0;
        }
    }


    private int getConditionPhysiqueScore(Demande demande){
        switch (demande.getConditionPhysique()){
            case INCAPABLE:
                return critere.getEtatPhysique();
            default:
                return 0;
        }
    }

    private int getEnfantsScore(Demande demande)  {
        int enfantsScore = 0;
        try {
            for(Enfant enf : demande.getEnfants()){
                setEnfAge(enf);
                if(enf.getAge() <=0 || enf.getAge() >= 25){
                    throw new Exception("Age est non valid");
                }
                else {
                    enfantsScore += critere.getValeurChaqueEnfant();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return enfantsScore;
    }
    private int getAncienneteAndAge(Demande demande){
        int score = 0;
        try{
            score = ((int)demande.getAnciennete() * critere.getAnciennete())
                    + ((int)demande.getAge() * critere.getAge());
        }catch (Exception e){
            e.printStackTrace();
        }
        return score;
    }
    private void setEnfAge(Enfant enf){
        enf.setNaissance(enf.getNaissance());
    }
}
