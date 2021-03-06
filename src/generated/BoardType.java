//
// Diese Datei wurde mit der JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 generiert 
// Siehe <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �nderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
// Generiert: 2017.06.20 um 02:40:06 PM CEST 
//


package generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse f�r boardType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="boardType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="row" maxOccurs="7" minOccurs="7">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="col" type="{}cardType" maxOccurs="7" minOccurs="7"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="shiftCard" type="{}cardType"/>
 *         &lt;element name="forbidden" type="{}positionType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "boardType", propOrder = {
    "row",
    "shiftCard",
    "forbidden"
})
public class BoardType {

    @XmlElement(required = true)
    protected List<BoardType.Row> row;
    @XmlElement(required = true)
    protected CardType shiftCard;
    protected PositionType forbidden;

    /**
     * Gets the value of the row property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the row property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRow().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link BoardType.Row }
     * 
     * 
     */
    public List<BoardType.Row> getRow() {
        if (row == null) {
            row = new ArrayList<BoardType.Row>();
        }
        return this.row;
    }

    /**
     * Ruft den Wert der shiftCard-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link CardType }
     *     
     */
    public CardType getShiftCard() {
        return shiftCard;
    }

    /**
     * Legt den Wert der shiftCard-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link CardType }
     *     
     */
    public void setShiftCard(CardType value) {
        this.shiftCard = value;
    }

    /**
     * Ruft den Wert der forbidden-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PositionType }
     *     
     */
    public PositionType getForbidden() {
        return forbidden;
    }

    /**
     * Legt den Wert der forbidden-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PositionType }
     *     
     */
    public void setForbidden(PositionType value) {
        this.forbidden = value;
    }


    /**
     * <p>Java-Klasse f�r anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="col" type="{}cardType" maxOccurs="7" minOccurs="7"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "col"
    })
    public static class Row {

        @XmlElement(required = true)
        protected List<CardType> col;

        /**
         * Gets the value of the col property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the col property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCol().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link CardType }
         * 
         * 
         */
        public List<CardType> getCol() {
            if (col == null) {
                col = new ArrayList<CardType>();
            }
            return this.col;
        }

    }

}
