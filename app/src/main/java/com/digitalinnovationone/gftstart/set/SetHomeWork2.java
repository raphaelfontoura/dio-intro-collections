package com.digitalinnovationone.gftstart.set;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetHomeWork2 {

    public static void main(String[] args) {

        Set<LanguageProgramming> favoritesLanguages = new LinkedHashSet<>() {
            {
                add(new LanguageProgramming("Java", 1995, "IntelliJ"));
                add(new LanguageProgramming("Javascript", 1995, "VSCode"));
                add(new LanguageProgramming("C#", 2000, "VSCode"));
            }
        };
        System.out.println("Linguagens favoritas por ordem de inserção:");
        favoritesLanguages.forEach(System.out::println);

        System.out.println("Linguagens favoritas ordenadas por nome:");
        Set<LanguageProgramming> favoritesOrderByName = new TreeSet<>(favoritesLanguages);
        favoritesOrderByName.forEach(System.out::println);

        System.out.println("Ordenadas por IDE:");
        Set<LanguageProgramming> languagesByIDE = new TreeSet<>(Comparator.comparing(LanguageProgramming::getIde));
        languagesByIDE.addAll(favoritesLanguages);
        languagesByIDE.forEach(System.out::println);

        System.out.println("Ordenadas por Ano e nome:");
        Set<LanguageProgramming> languagesByYearName = new TreeSet<>(new CompareLanguageByYearAndName());
        languagesByYearName.addAll(favoritesLanguages);
        languagesByYearName.forEach(System.out::println);

        System.out.println("Ordenadas por Nome, ano e IDE");
        Set<LanguageProgramming> languagesByAll = new TreeSet<>(new CompareLanguageByNameYearIDE());
        languagesByAll.addAll(favoritesLanguages);
        languagesByAll.forEach(System.out::println);

    }

}

class LanguageProgramming implements Comparable<LanguageProgramming> {

    private String name;
    private Integer bornYear;
    private String ide;

    public LanguageProgramming(String name, Integer year, String ide) {
        this.name = name;
        this.bornYear = year;
        this.ide = ide;
    }

    public String getName() {
        return name;
    }

    public Integer getBornYear() {
        return bornYear;
    }

    public String getIde() {
        return ide;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((bornYear == null) ? 0 : bornYear.hashCode());
        result = prime * result + ((ide == null) ? 0 : ide.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        LanguageProgramming other = (LanguageProgramming) obj;
        if (bornYear == null) {
            if (other.bornYear != null)
                return false;
        } else if (!bornYear.equals(other.bornYear))
            return false;
        if (ide == null) {
            if (other.ide != null)
                return false;
        } else if (!ide.equals(other.ide))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "[bornYear=" + bornYear + ", ide=" + ide + ", name=" + name + "]";
    }

    @Override
    public int compareTo(LanguageProgramming o) {
        return this.name.compareToIgnoreCase(o.getName());
    }
}

class CompareLanguageByYearAndName implements Comparator<LanguageProgramming> {

    @Override
    public int compare(LanguageProgramming lang0, LanguageProgramming lang1) {
        if (Integer.compare(lang0.getBornYear(), lang1.getBornYear()) == 0) {
            return lang0.getName().compareToIgnoreCase(lang1.getName());
        }
        return Integer.compare(lang0.getBornYear(), lang1.getBornYear());
    }

}

class CompareLanguageByNameYearIDE implements Comparator<LanguageProgramming> {

    @Override
    public int compare(LanguageProgramming lang0, LanguageProgramming lang1) {
        var compareName = lang0.getName().compareToIgnoreCase(lang1.getName());
        if (compareName != 0) {
            return compareName;
        }
        var compareYear = Integer.compare(lang0.getBornYear(), lang1.getBornYear());
        if (compareYear != 0) {
            return compareYear;
        }
        return lang0.getIde().compareToIgnoreCase(lang1.getIde());
    }

}
