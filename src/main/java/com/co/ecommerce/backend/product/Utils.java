package com.co.ecommerce.backend.product;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.font.Standard14Fonts;

public class Utils {
    
    static ByteArrayOutputStream createReport(List<ProductEntity> products)  throws IOException {
        try (PDDocument document = new PDDocument()) {
        int arraySize = products.size();
        double total = Math.ceil((double) arraySize / 50);
        int index = 0;

            for (int i = 0; i < total; i++) {
                PDPage page = new PDPage();
                document.addPage(page);
                float initPosY = page.getMediaBox().getHeight()-30;

                try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                    contentStream.beginText();
                    contentStream.setFont(new PDType1Font(Standard14Fonts.FontName.TIMES_ROMAN), 12);
                    contentStream.setLeading(15f);
                    contentStream.newLineAtOffset(25, initPosY);

                    for (int j = 0; index < arraySize && j < 50; j++) {
                        ProductEntity product = products.get(index++);
                        contentStream.showText(
                           " Name: "+ product.getName() 
                         + " - Code: "+ product.getCode()
                         + " - Characteristic: "+ product.getCharacteristic()
                         + " - Quantity: "+ product.getQuantity());
                        contentStream.newLine();
                    }
                    contentStream.endText();
                }
            }
            ByteArrayOutputStream  buf = new ByteArrayOutputStream();
            document.save(buf);
            return buf;
        }
    }
}
