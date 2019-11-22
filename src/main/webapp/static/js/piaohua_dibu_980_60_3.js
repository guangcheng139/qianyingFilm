document.writeln("<script>");
document.writeln("(function() {");
document.writeln("    var s = \"_\" + Math.random().toString(36).slice(2);");
document.writeln("    document.write(\'<div id=\"\' + s + \'\"><\/div>\');");
document.writeln("    (window.slotbydup=window.slotbydup || []).push({");
document.writeln("        id: \'2451728\',");
document.writeln("        container: s,");
document.writeln("        size: \'960,90\',");
document.writeln("        display: \'inlay-fix\'");
document.writeln("    });");
document.writeln("})();");
document.writeln("<\/script>");
document.writeln("<script src=\"https:\/\/dup.baidustatic.com\/js\/os.js\"><\/script>")