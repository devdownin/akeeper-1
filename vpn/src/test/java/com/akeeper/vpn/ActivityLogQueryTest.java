package com.akeeper.vpn;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ActivityLogQueryTest {

    @Test
    void filteredKeepsAppAndLimitAndNormalisesText() {
        var base = new ActivityLog.Query(false, 10_123, 500);
        var filtered = base.filtered(false, true, null);

        assertThat(filtered.uid()).isEqualTo(10_123);
        assertThat(filtered.limit()).isEqualTo(500);
        assertThat(filtered.allowedOnly()).isTrue();
        assertThat(filtered.text()).isEmpty();
    }

    @Test
    void threeArgumentConstructorAppliesNoExtraFilter() {
        var query = new ActivityLog.Query(true, ActivityLog.Query.ANY_UID, 3);

        assertThat(query.allowedOnly()).isFalse();
        assertThat(query.text()).isEmpty();
    }
}
