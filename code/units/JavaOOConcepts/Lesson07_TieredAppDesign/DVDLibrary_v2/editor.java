public void editor(String key, int ui) {
    String currentKey = key;
    Dvd dvd = dvds.getDvd(currentKey);
    String tempVal;
    String confirm;
    int tempNum;
    switch (ui) {
      case 1:
        tempVal = c.gets("Enter new title: ");
        c.println("Old title: " + dvd.getTitle());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setTitle(tempVal);
          dvds.add(dvd);
          currentKey = tempVal;
        } else {
          c.println("No changes made.\n");
        }

        break;
      case 2:
        tempNum = c.getsNum("Enter new release year: ");
        c.println("Old release year: " + dvd.getYear());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setYear(tempNum);
        } else {
          c.println("No changes made.\n");
        }

        break;
      case 3:
        tempVal = c.gets("Enter new rating: ");
        c.println("Old rating: " + dvd.getMpaaRating());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setMpaaRating(tempVal);
        } else {
          c.println("No changes made.\n");
        }
        break;
      case 4:
        tempVal = c.gets("Enter new director: ");
        c.println("Old director: " + dvd.getDirector());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setDirector(tempVal);
        } else {
          c.println("No changes made.\n");
        }
        break;
      case 5:
        tempVal = c.gets("Enter new studio: ");
        c.println("Old studio: " + dvd.getStudio());
        confirm = c.gets("Confirm change (y/n): ");
        if (confirm.equalsIgnoreCase("y")) {
          dvd.setStudio(tempVal);
        } else {
          c.println("No changes made.\n");
        }
        break;
      case 6:
        notesEditor(key);
        break;
      case 7:
        c.println("Cancelled.");
        break;
      default:
        break;
    }
    c.println("Updated record:");
    find(currentKey);
  }