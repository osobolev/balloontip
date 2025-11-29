module io.github.osobolev.balloontip {
    exports net.java.balloontip;
    exports net.java.balloontip.positioners;
    exports net.java.balloontip.styles;
    exports net.java.balloontip.utils;

    opens net.java.balloontip.images;

    requires transitive java.desktop;
}
