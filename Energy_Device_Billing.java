import java.util.*;

class EnergyDevice {
    private double units, rate, cost;
    private String source;

    public void set_units(double u) {
        units = u;
    }

    public void set_rate(double r) {
        rate = r;
    }

    public void set_source(String s) {
        source = s;
    }

    public void calculate_cost() {
        cost = units * rate;
    }

    public double get_cost() {
        return cost;
    }

    public boolean matches(EnergyDevice other) {
        return cost == other.cost
            && source.equals(other.source);
    }
}

abstract class BillingPolicy {
    public abstract double bill(EnergyDevice device);
}

class StandardBilling extends BillingPolicy {
    @Override
    public double bill(EnergyDevice device) {
        return device.get_cost();
    }
}

class ServiceBilling extends BillingPolicy {
    private double fee;

    public ServiceBilling(double fee) {
        this.fee = fee;
    }

    @Override
    public double bill(EnergyDevice device) {
        return device.get_cost() + fee;
    }
}

public class Energy_Device_Billing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        StringBuilder output = new StringBuilder();

        while (T-- > 0) {
            double u1 = sc.nextDouble();
            double r1 = sc.nextDouble();
            String s1 = sc.next();

            double u2 = sc.nextDouble();
            double r2 = sc.nextDouble();
            String s2 = sc.next();

            String mode = sc.next();
            double extra = sc.nextDouble();

            EnergyDevice a = new EnergyDevice();
            EnergyDevice b = new EnergyDevice();

            a.set_units(u1);
            a.set_rate(r1);
            a.set_source(s1);
            a.calculate_cost();

            b.set_units(u2);
            b.set_rate(r2);
            b.set_source(s2);
            b.calculate_cost();

            BillingPolicy policy = mode.equals("STANDARD")
                ? new StandardBilling()
                : new ServiceBilling(extra);

            output.append(a.matches(b)
                ? "Matching Devices"
                : "Non-Matching Devices").append('\n');

            output.append(String.format(
                Locale.US,
                "%.2f %.2f%n",
                policy.bill(a),
                policy.bill(b)
            ));
        }

        System.out.print(output);
        sc.close();
    }
}
