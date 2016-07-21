/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package syscheck;

/**
 *
 * @author ludiwang
 */
public class CompareValues {

    public enum SingleCompareOperators {

        LESSTHAN,
        LESSOREQUALTHAN,
        EQUAL,
        MORETHAN,
        MOREOREQUALTHAN,
        CONTAINS
    }

    public CompareValues() {

    }

    public static boolean compareSingelValue(String vSource, String vTarget, SingleCompareOperators vOperator) {
        Boolean vResult = false;

        switch (vOperator) {
            case EQUAL:
                vResult = vSource.equalsIgnoreCase(vTarget);
                break;
            case CONTAINS:
                vResult = vSource.toLowerCase().contains(vTarget.toLowerCase());
                break;
        }

        return vResult;

    }

    public static boolean compareSingelValue(double vSource, double vTarget, SingleCompareOperators vOperator) {
        Boolean vResult = false;

        switch (vOperator) {
            case EQUAL:
                if (vSource == vTarget) {
                    vResult = true;
                }
                ;
                break;
            case LESSTHAN:
                if (vSource < vTarget) {

                    vResult = true;
                }
                break;
            case LESSOREQUALTHAN:
                if (vSource <= vTarget) {
                    vResult = true;
                }
                break;

            case MORETHAN:
                if (vSource > vTarget) {
                    vResult = true;
                }
                break;
            case MOREOREQUALTHAN:
                if (vSource >= vTarget) {
                    vResult = true;
                }
                break;
        }

        return vResult;

    }
    
    

}

